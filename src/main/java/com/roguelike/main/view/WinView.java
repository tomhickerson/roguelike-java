package com.roguelike.main.view;

import org.hexworks.zircon.api.ColorThemes;
import org.hexworks.zircon.api.ComponentDecorations;
import org.hexworks.zircon.api.Components;
import org.hexworks.zircon.api.Functions;
import org.hexworks.zircon.api.component.ComponentAlignment;
import org.hexworks.zircon.api.grid.TileGrid;
import org.hexworks.zircon.api.view.base.BaseView;

public class WinView extends BaseView {

    private final TileGrid grid;

    public WinView(TileGrid grid) {
        super(grid, ColorThemes.arc());
        this.grid = grid;
    }

    @Override
    public void onDock() {
        var header = Components.header()
                .withText("You won!")
                .withAlignmentWithin(getScreen(), ComponentAlignment.CENTER)
                .build();

        var restartButton = Components.button()
                .withAlignmentAround(header, ComponentAlignment.BOTTOM_LEFT)
                .withText("Restart")
                .withDecorations(ComponentDecorations.box())
                .build();

        var exitButton = Components.button()
                .withAlignmentAround(header, ComponentAlignment.BOTTOM_RIGHT)
                .withText("Quit")
                .withDecorations(ComponentDecorations.box())
                .build();

        restartButton.onActivated(Functions.fromConsumer(event -> {
            replaceWith(new PlayView(grid));
        }));

        exitButton.onActivated(Functions.fromConsumer(event -> {
            System.exit(0);
        }));

        getScreen().addComponents(header, restartButton, exitButton);
    }
}