package com.codecool.healthplate.initializer;


import com.codecool.healthplate.models.Ingredient;
import com.codecool.healthplate.models.Recipe;
import com.codecool.healthplate.models.User;
import com.codecool.healthplate.services.IngredientService;
import com.codecool.healthplate.services.RecipeService;
import com.codecool.healthplate.services.UserService;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Date;

@Component
public class InitializerBean {


    public InitializerBean(UserService us, RecipeService rs, IngredientService is) {
        User user = new User("Emanuel","11","11@11");
        us.saveUser(user);
        Ingredient ingredient = new Ingredient("Egg", 12);
        Recipe recipe = new Recipe("Omlette","Need Eggs", new ArrayList<>(),"https://img.sndimg.com/food/image/upload/w_896,h_504,c_fill,fl_progressive,q_80/v1/img/recipes/82/53/8/RkND79iJRAytDrkaoSdE_easy-omelette-3784.jpg", user);
        Recipe recipe1 = new Recipe("Sausage","Delicious", new ArrayList<>(),"https://az808821.vo.msecnd.net/content/images/thumbs/0000239_polish-pork-sausages-sugar-free-five-025-lb-sausages_560.jpeg", user);
        Recipe recipe2 = new Recipe("Oriental Soup","Some way longer description than expected.", new ArrayList<>(),"https://i1.wp.com/welovebudapest.com/wp-content/uploads/sites/3/2015/07/6ba0d711e69b308af15ebc8d26709079.jpg?resize=1920%2C1080&ssl=1", user);
        recipe.addIngredient(ingredient);
        is.saveIngredient(ingredient);
        rs.saveRecipe(recipe);
        rs.saveRecipe(recipe1);
        rs.saveRecipe(recipe2);
    }
}
