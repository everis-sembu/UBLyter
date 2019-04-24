package com.everis.sembu.blyter.conf;

public class Parameter {

        protected String
                name,
                value,
                description,
                type,
                symbol;

        public Parameter(){}

        public Parameter(String name, String value, String description, String type, String symbol) {
            this.name = name;
            this.value = value;
            this.type = type;
            this.symbol = symbol;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getDescription() {return description;}

        public void setDescription(String description) {this.description = description;}

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
}

