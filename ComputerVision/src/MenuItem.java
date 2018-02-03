/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lewis
 */
public class MenuItem {
    private final String imgPath;
    private final String name;
    private final String description;
    
    public MenuItem(String imgPath, String name, String description) {
        this.imgPath = imgPath;
        this.name = name;
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    
}
