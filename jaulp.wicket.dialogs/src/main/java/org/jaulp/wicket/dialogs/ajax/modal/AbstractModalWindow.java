/**
 * Copyright (C) 2007 Asterios Raptis
 *
 * This program is open source software; you can redistribute it and/or modify
 * it under the terms of the Apache License V2.0 as published by
 * the Apache Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY.
 */
package org.jaulp.wicket.dialogs.ajax.modal;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.model.IModel;

/**
 * The Class AbstractModalWindow.
 *
 */
public abstract class AbstractModalWindow<T> extends ModalWindow {

	/**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new abstract modal window.
     *
     * @param id the id
     * @param title the title
     * @param initialWidth the initial width
     * @param initialHeight the initial height
     * @param component the component
     */
    public AbstractModalWindow( final String id, final String title,
            final int initialWidth, final int initialHeight,
            final Component component ) {
        super( id );
        init(title, initialWidth, initialHeight, component);
    }

    /**
     * Instantiates a new abstract modal window.
     *
     * @param id the id
     * @param model the model
     * @param title the title
     * @param initialWidth the initial width
     * @param initialHeight the initial height
     * @param component the component
     */
    public AbstractModalWindow( final String id, final IModel<T> model, final String title,
            final int initialWidth, final int initialHeight,
            final Component component ) {
        super( id, model );
        init(title, initialWidth, initialHeight, component);
    }

    /**
     * Instantiates a new abstract modal window.
     *
     * @param id the id
     * @param initialWidth the initial width
     * @param initialHeight the initial height
     * @param component the component
     */
    public AbstractModalWindow( final String id,  
            final int initialWidth, final int initialHeight,
            final Component component ) {
        this(id, null, initialWidth, initialHeight, component);
    }


	/**
	 * Initialize the given fields.
	 *
	 * @param title the title
	 * @param initialWidth the initial width
	 * @param initialHeight the initial height
	 * @param component the component
	 */
	private void init(final String title, final int initialWidth,
			final int initialHeight, final Component component) {
		if(title != null){
            setTitle( title );
        }
        setInitialWidth( initialWidth );
        setInitialHeight( initialHeight );
        setContent( component );
	}

    /**
     * On cancel.
     *
     * @param target the target
     */
    public abstract void onCancel( AjaxRequestTarget target );

    /**
     * On select.
     *
     * @param target the target
     * @param object the object
     */
    public abstract void onSelect( AjaxRequestTarget target, T object );

}