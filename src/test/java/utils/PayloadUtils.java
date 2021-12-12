package utils;

public class PayloadUtils {


    public static String getPetPayload(String petId, String petName, String petStatus) {
        String petPayload = "{\n" +
                "  \"id\": \"" + petId + "\",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"from java\"\n" +
                "  },\n" +
                "  \"name\": \"" + petName + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + petStatus + "\"\n" +
                "}";
        return petPayload;
    }

    public static String getSlackPayload(){
        String slackPayload = "{\n" +
                "  \"channel\": \"C02QAME99B7\",\n" +
                "  \"text\": \"Temirlan\"\n" +
                "}";
        return slackPayload;
    }









}
