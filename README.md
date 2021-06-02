# currencyCodeGetter Library

Easy to handle Library in Java for android.

Explanation:

It is a library that deals with countries currency codes that provide 3 functions:

getAvailableCurrencies - does not receive anything and returns a map of conversion codes in English and countries in the language in which the phone is set up(Local).

getCountryByCurrencyCode - receives a string of a currency code and returns an ArrayList of the countries that use the entered currency code.

getCurrencyCodeByCountry - receives a country string and returns its currency code string.


An internal util function (isEnglish) is used that receives a string and checks whether the text entered in the English language returns true or false

For the reason that inserting a country string in the English language requires the first letter to be uppercase and the rest lowercase for example Israel.

Hope u will find it usefull. :)
