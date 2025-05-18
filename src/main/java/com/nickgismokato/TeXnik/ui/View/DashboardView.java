package com.nickgismokato.TeXnik.ui.View;

import com.nickgismokato.TeXnik.ui.MainView;
import com.nickgismokato.TeXnik.backend.Data.Item;
import com.nickgismokato.TeXnik.backend.Data.Enum.CategoryEnum;
import com.nickgismokato.TeXnik.backend.Data.Repo.ItemRepository;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Route(value = "Dashboard", layout = MainView.class)
@PageTitle("Dashboard View")
@RouteAlias(value = "", layout = MainView.class)
public class DashboardView extends VerticalLayout{
    private final ItemRepository itemRepository;

    @Autowired
    public DashboardView(ItemRepository itemRepository){
        this.itemRepository = itemRepository;

		// Center layout.
		setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);

        // Page title
        add(new Text("Dashboard"));

        // Donut chart
        add(createDonutChart());
    }

    private Div createDonutChart(){
		// Fetch all items
		List<Item> items = itemRepository.findAll();
	
		// Group items by CatID and count them
		Map<CategoryEnum, Long> categoryCounts = items.stream()
				.filter(item -> CategoryEnum.fromInteger(item.getCatID()) != null) // Filter out invalid categories
				.collect(Collectors.groupingBy(
						item -> CategoryEnum.fromInteger(item.getCatID()),
						Collectors.counting()
				));
	
		// Prepare data for ApexCharts
		String categoriesJson = categoryCounts.keySet().stream()
				.map(CategoryEnum::name)
				.collect(Collectors.joining("\",\"", "[\"", "\"]")); // Convert to JSON array string
	
		String countsJson = categoryCounts.values().stream()
				.map(String::valueOf)
				.collect(Collectors.joining(",", "[", "]")); // Convert to JSON array string
	
		// Create a Div to hold the chart
		Div chartDiv = new Div();
		chartDiv.setId("donut-chart");
		chartDiv.setWidth("400px");
		chartDiv.setHeight("400px");
	
		// Add JavaScript to render the chart
		chartDiv.getElement().executeJs(
				"setTimeout(function() {" +
						"var options = {" +
						"chart: { type: 'donut' }," +
						"series: JSON.parse($0)," + // Parse counts JSON string into JavaScript array
						"labels: JSON.parse($1)," + // Parse categories JSON string into JavaScript array
						"title: {" +
						"  text: 'Total Unique Items in Storage'," + // Add chart title
						"  align: 'center'," +
						"  offsetX: -60," + // Move title 60px to the left
						"  style: {" +
						"    fontSize: '16px'," + // Adjust font size for title
						"    fontWeight: 'bold'," + // Make title bold
						"    color: '#FFFFFF'" + // Set title color to white
						"  }" +
						"}," +
						"plotOptions: {" +
						"  pie: {" +
						"    donut: {" +
						"      labels: {" +
						"        show: true," +
						"		 value: {" +
						"          show: true," +
						"          fontSize: '14px'," + // Adjust font size for value labels
						"          fontWeight: 'bold'," + // Make value labels bold
						"          color: '#FFFFFF'," + // Set color for value labels to white
						"          formatter: function(w) {" +
						"            return w.globals.seriesTotals.reduce((a, b) => a + b, 0);" + // Calculate total
						"          }," +
						"        }," +
						"        total: {" +
						"          show: true," +
						"          label: 'Total'," +
						"          fontSize: '14px'," + // Adjust font size for total label
						"          fontWeight: 'bold'," + // Make total label bold
						"          color: '#FFFFFF'," + // Set color for total label to white
						"          formatter: function(w) {" +
						"            return w.globals.seriesTotals.reduce((a, b) => a + b, 0);" + // Calculate total
						"          }," +
						"        }" +
						"      }" +
						"    }" +
						"  }" +
						"}," +
						"dataLabels: {" +
						"  style: {" +
						"    fontSize: '12px'," + // Adjust font size for data labels
						"    fontWeight: 'bold'," + // Make data labels bold
						"    color: '#FFFFFF'" + // Set data label color to white
						"  }" +
						"}," +
						"legend: {" +
						"  labels: {" +
						"    colors: Array(JSON.parse($1).length).fill('#FFFFFF')," + // Set legend text color to white for all items
						"    useSeriesColors: false" +
						"  }," +
						"  fontSize: '12px'," + // Adjust font size for legend
						"  fontWeight: 'bold'" + // Make legend text bold
						"}," +
						"responsive: [{" +
						"  breakpoint: 480," +
						"  options: {" +
						"    chart: { width: 300 }," +
						"    legend: { position: 'bottom' }" +
						"  }" +
						"}]" +
						"};" +
						"console.log('Series:', JSON.parse($0), 'Labels:', JSON.parse($1));" + // Log data
						"var chart = new ApexCharts(document.querySelector('#donut-chart'), options);" +
						"chart.render();" +
				"}, 100);", // Delay execution by 100ms
				countsJson, categoriesJson // Pass JSON strings
		);
	
		return chartDiv;
	}
}