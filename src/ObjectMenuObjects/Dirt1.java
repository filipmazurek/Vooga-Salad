package ObjectMenuObjects;

import ui.GridPaneNode;
import block.BlockType;
import javafx.scene.image.Image;

public class Dirt1 extends GameObjects {

    private final String PATH = "resources/images/tiles/decorations/dirt-1";

    public Dirt1() {
        super();
        Image image = new Image(PATH + ".png");
        imageView.setImage(image);
        path = PATH;
        blockType = BlockType.DECORATION;
    }

    @Override
    public void populateList() {
        String name = PATH + ".png";
        GridPaneNode tempNode = new GridPaneNode(0, 0, name);
        list.add(tempNode);
    }
}
