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
package org.dropdownchoices.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.wicket.util.io.IClusterable;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

/**
 * The Class GenericTwoDropDownChoicesModel.
 *
 * @param <T> the generic type
 */
public class GenericTwoDropDownChoicesModel< T > implements IClusterable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The selected root option. */
    private T selectedRootOption;

	/** The selected child option. */
    private T selectedChildOption;

    /** The models map. */
    private Map< T, List< T >> modelsMap = new HashMap< T, List< T >>();

    /** The root choices. */
    private IModel< List< T >> rootChoices;

    /** The child choices. */
    private IModel< List< T >> childChoices;

    /**
     * Instantiates a new generic two drop down choices model.
     *
     * @param selectedOption the selected option
     * @param modelsMap the models map
     */
    public GenericTwoDropDownChoicesModel( final T selectedOption,
            final Map< T, List< T >> modelsMap ) {
        this.modelsMap = modelsMap;

        rootChoices = new AbstractReadOnlyModel< List< T >>() {

            private static final long serialVersionUID = 1L;

            @Override
            public List< T > getObject() {
                Set< T > keys = modelsMap.keySet();
                List< T > list = new ArrayList< T >( keys );
                return list;
            }

        };
        this.selectedRootOption = selectedOption;

        getChildChoices();

    }

    /**
     * Gets the child choices.
     *
     * @return the child choices
     */
    public IModel< List< T >> getChildChoices() {
        childChoices = new AbstractReadOnlyModel< List< T >>() {

            /** The Constant serialVersionUID. */
            private static final long serialVersionUID = 1L;

            @Override
            public List< T > getObject() {
                List< T > models = getModelsMap().get( getSelectedRootOption() );
                if ( models == null ) {
                    models = Collections.emptyList();
                }
                return models;
            }

        };
        return childChoices;
    }

    /**
     * Gets the models map.
     *
     * @return the models map
     */
    public Map< T, List< T >> getModelsMap() {
        return modelsMap;
    }

    /**
     * Gets the root choices.
     *
     * @return the root choices
     */
    public IModel< List< T >> getRootChoices() {
        return rootChoices;
    }

    /**
     * Gets the selected child option.
     *
     * @return the selected child option
     */
    public T getSelectedChildOption() {
        return selectedChildOption;
    }

    /**
     * Gets the selected root option.
     *
     * @return the selected root option
     */
    public T getSelectedRootOption() {
        return selectedRootOption;
    }

    /**
     * Sets the models map.
     *
     * @param modelsMap the models map
     */
    public void setModelsMap( final Map< T, List< T >> modelsMap ) {
        this.modelsMap = modelsMap;
    }

    /**
     * Sets the selected child option.
     *
     * @param selectedChildOption the new selected child option
     */
    public void setSelectedChildOption( final T selectedChildOption ) {
        this.selectedChildOption = selectedChildOption;
    }

    public void setSelectedRootOption(T selectedRootOption) {
		this.selectedRootOption = selectedRootOption;
	}

}
