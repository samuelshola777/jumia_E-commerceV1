package com.example.jumia_Ecommerce.securityConfig.endPoints;

public class NonAccessAbleEndpoints {
    public static String[] blackLabelEndPoints(){
return new String[]{"/api/wareHouse/register",
                "/api/wareHouse/update",
                "/api/wareHouse/deleteByName",
                "/api/wareHouse/deleteAll",
        "/api/wareHouse/getAllCategories"

        };
    }
}
