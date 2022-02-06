 # N11 - TEST AUTOMATION CASES (EN)

These test scenarios include the projects requested by N11 company. The following technologies were used in the project by using the BDD approach. Scenarios are provided to be run using the Page Object Model. 

</br></br>

## Project Features </br>

* The project was developed in Java with the Selenium Test Framework and JMeter (5.1.1). POM is used in architecture.
* Webdriver is used from [bonigarcia](https://github.com/bonigarcia/webdrivermanager) repo.
* It saves a screenshot when an error is encountered during the test. Screenshots are kept under src folder for [case1](https://github.com/ozgunbos/n11Cases/tree/main/case1) and target/html-reports for [case2](https://github.com/ozgunbos/n11Cases/tree/main/case2) 
* JUnit and TestNG library are used for annotations and assertions.
* Docker and Selenium Grid are used in [second case](https://github.com/ozgunbos/n11Cases/tree/main/case2).

</br></br>

## Installation Procedure </br>

* Installation steps for JMeter you can find [here](https://github.com/ozgunbos/n11Cases/tree/main/JMeter). 
* [MAVEN executable location](https://github.com/ozgunbos/n11Cases/blob/main/case2/pom.xml#L72) should be changed according to the operating system to test second case.
* In command prompt or bash screen, navigate to main folder to use Selenium Grid in Docker 
* Run following command  
``` docker-compose -f docker-compose.yaml up -d ```
```
 docker-compose: to build docker container
 -f: specify a path to a Compose file 
 up: start containers for a service
 -d: it runs in the background (detach mode)
```

* When everything is done Selenium Grid should be run at [http://localhost:4444/grid/console](http://localhost:4444/grid/console)
* To use Selenium Grid, runDocker property should be assign as "docker" in the configurations.properties file in the main directory.

```configurations.properties file```

``` 
browserName=chrome
baseURI=https://www.n11.com
websiteTitle=n11.com - Hayat Sana Gelir
runDocker=docker

```
* Also, ```browserName``` can be changed to firefox to use Firefox Driver.

* To run test following commands should be run.

``` mvn clean install ```

``` mvn clean test -Dtest=CucumberRunner ```

</br></br>

## Sample Project Video (Local Test and Selenium Grid in Docker)  </br> 

Password is ```secret``` to view session in Selenium Grid.

![](https://github.com/ozgunbos/n11Cases/blob/main/Ornek.gif)
