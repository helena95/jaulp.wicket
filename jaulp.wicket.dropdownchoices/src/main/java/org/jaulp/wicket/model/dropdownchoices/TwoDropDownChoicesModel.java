/**
 * Copyright (C) 2010 Asterios Raptis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jaulp.wicket.model.dropdownchoices;

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
 * The Class TwoDropDownChoicesModel.
 *
 * @param <T> the generic type
 */
public class TwoDropDownChoicesModel< T > implements IClusterable {

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
    public TwoDropDownChoicesModel( final T selectedOption,
            final Map< T, List< T >> modelsMap ) {
        this.modelsMap = modelsMap;

        rootChoices = new AbstractReadOnlyModel< List< T >>() {

            private static final long serialVersionUID = 1L;

            @Override
            public List< T > getObject() {
                Set< T > keys = modelsMap.keySet();
                List< T > keysList = new ArrayList< T >( keys );
                return keysList;
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
