package com.roguelike.main.view;

import org.hexworks.zircon.api.ColorThemes;
import org.hexworks.zircon.api.ComponentDecorations;
import org.hexworks.zircon.api.Components;
import org.hexworks.zircon.api.Functions;
import org.hexworks.zircon.api.component.Button;
import org.hexworks.zircon.api.component.Component;
import org.hexworks.zircon.api.component.ComponentAlignment;
import org.hexworks.zircon.api.grid.TileGrid;

import org.hexworks.zircon.api.view.base.BaseView;

public class StartView extends BaseView {

    private final TileGrid grid;

    public StartView(TileGrid grid) {
        super(grid, ColorThemes.arc());
        this.grid = grid;
    }

    @Override
    public void onDock() {
        String msg = "Welcome to Caves of Zircon.";

        // a text box can hold headers, paragraphs and list items
        // In Kotlin, `contentWidth = msg.length` is a keyword (named) parameter.
        // Java doesn't support named parameters, so we pass the value positionally.
        Component header = Components.textBox(msg.length())
                // we add a header
                .addHeader(msg)
                // and a new line
                .addNewLine()
                // and align it to center
                .withAlignmentWithin(getScreen(), ComponentAlignment.CENTER)
                .build(); // finally we build the component

        Button startButton = Components.button()
                // we align the button to the bottom center of our header
                .withAlignmentAround(header, ComponentAlignment.BOTTOM_CENTER)
                // its text is "Start!"
                .withText("Start!")
                // we want a box and some shadow around it
                .withDecorations(ComponentDecorations.box(), ComponentDecorations.shadow())
                .build();

        startButton.onActivated(Functions.fromConsumer(event -> {
            replaceWith(new PlayView(grid)); // 1
        }));

        // We can add multiple components at once
        getScreen().addComponents(header, startButton);

    }
}
