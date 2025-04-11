# < 0.2.1
Initial setup of the frame of webapplication.

# 0.2.1
### Overview
Mainly changed from `MySQL` to `PostgreSQL` to easier handle server setup and to have bette `JBA` control since `MySQL` is quite outdated. Moreover added some more `view` objects to the program and also added some promised features.

### Changed

- **Breaking:** Changed from `MySQL` to `PostgreSQL`. 
- **Breaking:** Changed internal handling of data. Now we utilize `Controller` paradigm more and can slowly make `Handler` classes obsolete.

### Added

- Added `ApexCharts.js` package to handle the graph creation used in `/src/main/java/com/nickgismokato/TeXnik/ui/View/DashboardView.java`. Can also be used other places.
- Added `src/main/resources/application.properties` line that request to use a file `/srv/texnikwebsiteproperties/env.properties`. Inside here the `DB_PASSWORD` should be created like this:
```properties
DB_PASSWORD=ExampleOfAPassword1234
```

### Removed
- Removed smaller code segments that handled `MySQL` queries. 
- Removed certain properties inside the `src/main/resources/application.properties`

### Fixed



# 1.0
**Initial build**

<!--

# x.y.z
### Overview

### Changed

### Added

### Removed

### Fixed

-->