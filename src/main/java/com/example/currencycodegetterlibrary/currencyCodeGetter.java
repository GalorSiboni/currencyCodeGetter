package com.example.currencycodegetterlibrary;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

    public class currencyCodeGetter {

        /**
         * This function return Map of Strings, when the keys is the countrys and the values is there currency codes
         * @return Map<String, String>
         */
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

        /**
         * This function return a ArrayList Countries as Strings when u give her a String of a Currency Code.
         * For example: give this currency code : "EUR" will return all the Countries that use a EURO.(The currency of the European Union)
         * @param cd String
         * @return
         */
        public ArrayList<String> getCountryByCurrencyCode(String cd) {
            String input = cd;
            if (isEnglish( input )) {
                input = input.toUpperCase();
            }
            Map<String, String> currencies = getAvailableCurrencies();
            ArrayList<String> countries = new ArrayList<>();
            if(currencies.values().contains( input )) {
                for (Map.Entry<String, String> entry : currencies.entrySet()) {
                    if (entry.getValue().equals(input)) {
                        countries.add(entry.getKey());
                    }
                }
            }
            if (countries.isEmpty())
                return null;
            else return countries;
        }

        /**
         * This function return String of a Currency Code when u give ger a String of a Country in the phone local language.
         * For example: give this country if your phone set to English: "Brazil" and the function will return "BRL" (The currency code of the Brazilian real).
         * @param country String
         * @return
         */
        public String getCurrencyCodeByCountry(String country) {
            String input = country;
            if (isEnglish( input )) {
                String temp = input.toLowerCase();
                input = temp.substring( 0, 1 ).toUpperCase() + temp.substring( 1 );
            }
            Map<String, String> currencies = getAvailableCurrencies();
            String cd = currencies.get(input);
            if (cd != null)
                return cd;
            return "Not Found!";
        }
        private boolean isEnglish(String text) {
            boolean onlyEnglish = false;

            for (char character : text.toCharArray()) {

                if (Character.UnicodeBlock.of(character) == Character.UnicodeBlock.BASIC_LATIN
                        || Character.UnicodeBlock.of(character) == Character.UnicodeBlock.LATIN_1_SUPPLEMENT
                        || Character.UnicodeBlock.of(character) == Character.UnicodeBlock.LATIN_EXTENDED_A
                        || Character.UnicodeBlock.of(character) == Character.UnicodeBlock.GENERAL_PUNCTUATION) {

                    onlyEnglish = true;
                } else {

                    onlyEnglish = false;
                }
            }

            return onlyEnglish;
        }
    }

