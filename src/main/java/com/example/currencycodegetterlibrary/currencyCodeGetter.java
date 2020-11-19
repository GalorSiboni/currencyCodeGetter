package com.example.currencycodegetterlibrary;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

    public class currencyCodeGetter {
        public Map<String, String> getAvailableCurrencies() {
            Locale[] locales = Locale.getAvailableLocales();

            // We use TreeMap so that the order of the data in the map sorted
            // based on the country name.
            Map<String, String> currencies = new TreeMap<>();
            for (Locale locale : locales) {
                try {
                    currencies.put( locale.getDisplayCountry(),
                            Currency.getInstance( locale ).getCurrencyCode() );
                } catch (Exception e) {
                    // when the locale is not supported
                }
            }
            return currencies;
        }

        public ArrayList<String> getCountryByCurrencyCode(String cd) {
            Map<String, String> currencies = getAvailableCurrencies();
            ArrayList<String> cuntries = new ArrayList<>();
            if(currencies.values().contains( cd )) {
                for (Map.Entry<String, String> entry : currencies.entrySet()) {
                    if (entry.getValue().equals(cd)) {
                        cuntries.add(entry.getKey());
                    }
                }
            }
            if (cuntries.isEmpty())
                return null;
            else return cuntries;
        }

        public String getCurrencyCodeByCountry(String country) {
            Map<String, String> currencies = getAvailableCurrencies();
            String cd = currencies.get(country);
            if (cd != null)
                return cd;
            return "Not Found!";
        }
    }

