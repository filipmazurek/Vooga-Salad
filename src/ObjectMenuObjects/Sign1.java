package ObjectMenuObjects;

import block.BlockType;
import javafx.scene.image.Image;
import ui.GridPaneNode;

public class Sign1 extends GameObjects {

    private final String PATH = "resources/images/tiles/obstacles/sign-1";

    public Sign1() {
        super();
        Image image = new Image(PATH + ".png");
        this.imageView.setImage(image);
        path = PATH;
        blockType = BlockType.OBSTACLE;
    }

    @Override
    public void populateList() {
        String name = PATH + ".png";
        GridPaneNode tempNode = new GridPaneNode(0, 0, name);
        list.add(tempNode);
    }
}
