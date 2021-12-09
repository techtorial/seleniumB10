package api.get;

import api.pojo.PokemonPojo;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Pokemon {
//https://pokeapi.co/api/v2/pokemon


    @Test
    public void getPokemonsTest() {
        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .when().get("https://pokeapi.co/api/v2/pokemon")
                .then().statusCode(200).log().all().extract().response();

        Map<String, Object> pokemonMap = response.as(new TypeRef<Map<String, Object>>() {
        });

        int actualCount = (int) pokemonMap.get("count");  // -> Object
        Assert.assertEquals(actualCount, 1118);

        List<Map<String, String>> resultsMap =
                (List<Map<String, String>>) pokemonMap.get("results"); // -> Object

        for (int i = 0; i < resultsMap.size(); i++) {
            Map<String, String> singlePokemon = resultsMap.get(i);
            String pokemonName = singlePokemon.get("name");
            System.out.println(pokemonName);
        }


    }

    @Test
    public void findPikachu() {
        //https://pokeapi.co/api/v2/pokemon?limit=1118
        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .param("limit", "1118")
                .when().get("https://pokeapi.co/api/v2/pokemon")
                .then().statusCode(200)
                .extract().response();

        Map<String, Object> pokemonMap = response.as(new TypeRef<Map<String, Object>>() {
        });
        List<Map<String, String>> pokemonList = (List<Map<String, String>>) pokemonMap.get("results");
        for (Map<String, String> pokemon : pokemonList) {
            String name = pokemon.get("name");
            if (name.equalsIgnoreCase("Pikachu")) {
                System.out.println(pokemon.get("url"));
            }
        }


    }

    @Test
    public void test3() {
        //https://pokeapi.co/api/v2/pokemon
        Response response = RestAssured.given().accept("application/json")
                .when().get("https://pokeapi.co/api/v2/pokemon")
                .then().statusCode(200)
                .and()
                .contentType("application/json; charset=utf-8")
                .extract().response();

        PokemonPojo pokemon = response.as(PokemonPojo.class);
        System.out.println(pokemon.getCount());

        Assert.assertEquals(pokemon.getCount(), 1118);
        System.out.println(pokemon.getNext());


    }


}
