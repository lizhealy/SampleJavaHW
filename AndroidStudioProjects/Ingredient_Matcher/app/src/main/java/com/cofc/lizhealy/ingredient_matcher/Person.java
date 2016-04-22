package com.cofc.lizhealy.ingredient_matcher;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lizhealy on 4/14/16.
 */
public class Person implements Serializable {

    public String score;
    public String popularity;
    public String name;
    public String id;
    public String biography;
    public String url;
    public String version;
    public String lastModifiedAt;
    public ArrayList<Image> imagesList;

}
