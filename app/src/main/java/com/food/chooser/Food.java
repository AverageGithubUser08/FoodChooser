package com.food.chooser;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Food {
    ArrayList<String> food = new ArrayList<>();

    public Food(Context context) throws FileNotFoundException {

        if (context == null) {
            return;
        }
        InputStream inputStream = context.getResources().openRawResource(R.raw.food);
        Scanner sc = new Scanner(inputStream);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            food.add(line);
        }
    }

    public String randomFood() throws FileNotFoundException {
        Random r = new Random();
        return food.get(r.nextInt(food.size()));
    }

}
