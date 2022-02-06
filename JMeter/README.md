## Installation Procedure </br>

</br> </br>

* You should have Apache JMeter 5.1.1 version and jdk8+ 

* Navigate to "bin" folder to run Apache JMeter. 

* You can run below command in Bash to run JMeter 

    ``` java -jar ApacheJMeter.jar ```
    
    or just run ``` "jmeterw.cmd"``` file in "bin" folder.

* There are two steps to run a test in JMeter.

* 1- Data Set Config for csv should be assigned as below in ```Data Set Config file```

<img alt="" src="https://github.com/ozgunbos/n11Cases/blob/main/JMeter/DataSetConfig.jpg">

* 2- Also, executable driver must be assigned as below in ```Chrome Driver Config file```

<img alt="" src="https://github.com/ozgunbos/n11Cases/blob/main/JMeter/JMeterAssignPath.jpg">


## JMeter Case Steps </br>

</br> </br>

* 15 products information is added to the CSV
* The product information is read from the CSV and added to the cart.
* While adding to the cart, It is checked whether the price of the product is below 100 TL.
If it is more than 100 TL, It will not be added to the cart.
* 10 items are added to the cart.
* Continue as a guest after adding 10 products in the cart. 
* Enter user information in user information page.
* Then try to buy products with wrong credentials.



</br></br>
## Sample Video for a test in JMeter </br>

![](https://github.com/ozgunbos/n11Cases/blob/main/JMeter/JMeter-Sample.gif)
