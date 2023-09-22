package com.example.jumia_Ecommerce.securityConfig.endPoints;

public class NonAccessAbleEndpoints {
    public static String[] blackLabelEndPoints(){
        return new String[]{"/jumia/api/wareHouse/register",
                "/jumia/api/wareHouse/update"
                ,"/jumia/api/wareHouse/deleteByName",
                "/jumia/api/wareHouse/deleteAll"};
    }
}
