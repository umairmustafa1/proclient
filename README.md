# README #

This application finds the cheapest flights for each day between **Origin** and **Destination** within a given date range (**From** to **To**).

# Features #

* User should enter the date range during which he/she is looking to travel and application will find the cheapest flight options for each day in the descending order.
* Auto complete Functionality for Origin and Destination helps to choose Origin and Destination easily.
* Results display the *cheapest* flight option for each day in the descending order for a given date range where X is the number of days. X is limited to 5 results.
* Each entry in results list display source , destination, date, Flight Number, Airline, Air Fare and Agent who offers that price. Moreover, it also displays logo of the airline.
* User can go to the reservation website of the agent upon clicking the result.

# Notes #
Currently wait time for pooling API is set to 2 seconds for a request. Sometimes it can take longer than 2 seconds, in those cases please press find again to get the output.