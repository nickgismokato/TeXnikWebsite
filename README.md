# $\TeX \texttt{nik}$ Website
This is the open source repository for the $\TeX \texttt{nik}$ Website for their inventory system togheter with general storage of their internal software and their documentation.
![Java](https://img.shields.io/badge/17-grey.svg?style=for-the-badge&logo=openjdk&logoColor=whitex&label=Java&labelColor=%23ED8B00)
![Apache Maven](https://img.shields.io/badge/3.8.3-grey?style=for-the-badge&logo=Apache%20Maven&logoColor=white&label=APache%20Maven&labelColor=C71A36)
![Vaadin](https://img.shields.io/static/v1?style=for-the-badge&message=24.3.19&color=grey&logo=Vaadin&logoColor=00B4F0&label=Vaadin&labelColor=222222)
![Spring Boot](https://img.shields.io/static/v1?style=for-the-badge&message=3.3.6&color=grey&logo=Spring+Boot&logoColor=FFFFFF&label=Spring%20Boot&labelColor=6DB33F)
![Spring](https://img.shields.io/static/v1?style=for-the-badge&message=6.1.15&color=grey&logo=Spring&logoColor=FFFFFF&label=Spring&labelColor=6DB33F)
![Spring Security](https://img.shields.io/static/v1?style=for-the-badge&message=6.1.15&color=grey&logo=Spring+Security&logoColor=FFFFFF&label=Spring%20Security&labelColor=6DB33F)
<!--![JUnit5](https://img.shields.io/static/v1?style=for-the-badge&message=5.10.2&color=grey&logo=JUnit5&logoColor=FFFFFF&label=JUnit5&labelCOlor=25A162)
![NodeJS](https://img.shields.io/badge/v20.18.1-grey?style=for-the-badge&logo=node.js&logoColor=white&label=node.js&labelColor=6DA55F)
![NPM](https://img.shields.io/badge/8.19.4-grey.svg?style=for-the-badge&logo=npm&logoColor=white&label=NPM&labelColor=%23CB3837)
![PNPM](https://img.shields.io/badge/7.33.7-grey.svg?style=for-the-badge&logo=pnpm&logoColor=white&label=PNPM&labelColor=%23CB3837)-->
## Requirements
This website is made to run on a Linux environment. For Windows or mac users who plan to run this website locally, either create a VM or for windows users (10+) use WSL2. 
|Dependency|Version|Optional|
|:---|:---:|---:|
|`Java`|17||
|`Maven`|3.8.3||
## Functionality of the website
The following list both works as an information of what functionality we want to implement and what we have implementet togheter with optional functionality we wish to implement later.
### Main functionality of the website
- [ ] Admin/User login
  - [ ] Anomynous user for non $\TeX \texttt{nik}$ end-users
- [ ] Display items in an ordered fashion
  - [ ] Catagorize item in main catagories: `Sound::0`, `Lighting::1`, `AV::2`, `Power::3`, `Extra::4`
  - [ ] Items have the following fields: `InternalID`, `SatyrID`, `CatID`, `EAN`, `Name`, `TotalAmount`, `Status`
- [ ] Display the storage and its content in an ordered fashion
  - [ ] Have a relantioship between items and their storage ID within our storage room 
- [ ] Both PC and mobile friendly
- [ ] Read QR-code or Barcodes with webcam/built-in camera
- [ ] Add, remove or update catagories, items and storage (**ADMIN**)
- [ ] Internal database structure and file handling so no need for external database
- [ ] Code documentation for the full website
### Secondary functionality of the website
- [ ] Use graphs to show current inventory stock
- [ ] Store software/documentation of processes on the website in either `.zip` or `.pdf` format
- [ ] Have an API for end-users to call to get the data of the items.
- [ ] 
## How to run
There are two options to run this application:
### 1) Manual installation `Java` run
To manual run this without the usage of `Spring-Boot`, firstly you must run `mvn clean install -Pproduction`. If the flag `-Pproduction` is not there, then it will compile a developer build by default.
Then when it has finished run the following command:
`java -jar -Dspring.profile=production src/target/TeXnikWebsite-<version>.jar`
Depending on your version, you will have to insert that yourself. Also make sure your target terminal is in the top most directory where the `pom.xml` is.
### 2) `Spring-Boot`
To run with `Spring-Boot` just navigate to the top most directory where the `pom.xml` is. From there run the following command: 
`mvn spring-boot:run -Pproduction`
Remove the flag `-Pproduction` if you wish to build the developer build.