package com.example.realdm99.chapter6;

import lombok.Data;

@Data
public class EnumTest {
    public enum PriceTaxClassify {
        TAX_INCLUDE("부가세 포함", "1", "TAX_INCLUDE"),
        TAX_EXCLUDE("부가세 별도", "2", "TAX_EXCLUDE"),
        TAX_FREE("비과세", "3", "TAX_FREE");

        private String description;
        private String lineFormatCode;
        private String lineCommerceCode;

        PriceTaxClassify(String description, String lineFormatCode, String lineCommerceCode) {
            this.description = lineFormatCode;
            this.lineFormatCode = lineFormatCode;
            this.lineCommerceCode = lineCommerceCode;
        }
    }

    private PriceTaxClassify priceTaxClassify;
}
