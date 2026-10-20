package Game;

import java.awt.*;

public final class Settings {
    public final static class GAME {
        public final static boolean DEBUG_MODE = false;
        public final static String TITLE = "Kashieru1987 - Snake";
        public final static int WIDTH = 500;
        public final static int HEIGHT = 500;
        public final static Color BACKGROUND_COLOR = Color.DARK_GRAY;
    }
    public final static class BLOCKS {
        public final static int COUNT_WIDE = 10;
        public final static int COUNT_HIGH = 10;
        public final static int DIAMETER = 40;
        public final static int PADDING = 3;
        public final static int TOTAL_WIDTH;
        public final static int TOTAL_HEIGHT;
        public final static Color BACKGROUND_COLOR = Color.BLACK;
        public final static Color EMPTY_COLOR = Color.GRAY;
        public final static Color SNAKE_COLOR = Color.GREEN;

        static {
            final int diameterWidth = DIAMETER * COUNT_WIDE;
            final int paddingWidth = PADDING * (COUNT_WIDE+1);
            TOTAL_WIDTH = diameterWidth + paddingWidth;

            final int diameterHeight = DIAMETER * COUNT_HIGH;
            final int paddingHeight = PADDING * (COUNT_HIGH+1);
            TOTAL_HEIGHT = diameterHeight + paddingHeight;
        }
    }
}
