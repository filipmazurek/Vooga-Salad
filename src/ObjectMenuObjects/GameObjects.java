package ObjectMenuObjects;
import java.util.*;

import javafx.scene.image.ImageView;
import ui.GridPaneNode;


public abstract class GameObjects {
    
    protected String path;
    protected String type;
    protected List<GridPaneNode> list;
    protected ImageView imageView;
    
    public GameObjects(){
        list = new ArrayList<GridPaneNode>();
        populateList();
        this.imageView = new ImageView();
    }
    public List<GridPaneNode> getList(){
        return list;
    }
    
    protected String reName(String a, int count){
        return a+"."+count+".png";
    }
    
    public abstract void populateList();
    
    public ImageView getImage(){
        return imageView;
    }
    
    public String getType(){
        return type;
    }
    
    public String getPath(){
        return path+".png";
    }
    
    public String toString(){
        return type;
    }
}