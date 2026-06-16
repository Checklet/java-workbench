package roleplay.gui;

import javax.swing.*;
import java.awt.*;

public class WorkbenchLayout implements LayoutManager {
    private static final int X = 120;
    private static final int Y = 28;
    private static final int GAP = 10;
    private static final int MARGIN = 20;

    private int width = 0;

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        final int count = parent.getComponentCount();

        if (count == 0)
            return new Dimension(MARGIN * 2, MARGIN * 2);

        if (count == 1)
            return new Dimension(MARGIN * 2 + X, MARGIN * 2 + Y);

        return new Dimension(
            MARGIN * 2 + GAP + X * 2,
            MARGIN * 2 + Y * ((count + 1) / 2) + GAP * ((count - 1) / 2)
        );
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return preferredLayoutSize(parent);
    }

    @Override
    public void layoutContainer(Container parent) {
        for (int i = 0; i < parent.getComponents().length; i++) {
            Component comp = parent.getComponent(i);

            if (i % 2 == 0) {
                comp.setBounds(
                    MARGIN,
                    MARGIN + (i / 2) * (GAP + Y) - 2,
                    getFirstRowWidth(parent),
                    Y
                );
            } else {
                comp.setBounds(
                    MARGIN + GAP + getFirstRowWidth(parent),
                    MARGIN + (i / 2) * (GAP + Y),
                    X,
                    Y
                );
            }

        }
    }

    private int getFirstRowWidth(Container parent) {
        if (this.width > 0) return this.width;

        int width = 0;

        for (int i = 0; i < parent.getComponents().length; i += 2)
            if (parent.getComponent(i) instanceof JLabel label)
                if (width < label.getText().length())
                    width = label.getText().length();

        return this.width = width * 11;
    }
}
