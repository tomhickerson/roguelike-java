package com.roguelike.main.view;

import org.hexworks.zircon.api.ColorThemes;
import org.hexworks.zircon.api.ComponentDecorations;
import org.hexworks.zircon.api.Components;
import org.hexworks.zircon.api.Functions;
import org.hexworks.zircon.api.component.ComponentAlignment;
import org.hexworks.zircon.api.grid.TileGrid;

import org.hexworks.zircon.api.view.base.BaseView;

public class PlayView extends BaseView {

    private final TileGrid grid;

    public PlayView(TileGrid grid) {
        super(grid, ColorThemes.arc());
        this.grid = grid;
    }
    @Override
    public void onDock() {
        var loseButton = Components.button()
                .withAlignmentWithin(getScreen(), ComponentAlignment.LEFT_CENTER)
                .withText("Lose!")
                .withDecorations(ComponentDecorations.box(), ComponentDecorations.shadow())
                .build();

        var winButton = Components.button()
                .withAlignmentWithin(getScreen(), ComponentAlignment.RIGHT_CENTER)
                .withText("Win!")
                .withDecorations(ComponentDecorations.box(), ComponentDecorations.shadow())
                .build();

        loseButton.onActivated(Functions.fromConsumer(event -> {
            replaceWith(new LoseView(grid));
        }));

        winButton.onActivated(Functions.fromConsumer(event -> {
            replaceWith(new WinView(grid));
        }));

        getScreen().addComponents(loseButton, winButton);
    }


}
