package org.dropdownchoices.models;

import java.util.List;
import java.util.Map;

/**
 * The Class GenericThreeDropDownChoicesModel.
 *
 * @param <T> the generic type
 * @author Asterios Raptis
 */
public class GenericThreeDropDownChoicesModel< T > extends
        GenericTwoDropDownChoicesModel< T > {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The selected option. */
    private T selectedValueOption;

    /** The child choices. */
    private List< T > selectedValuesChoices;

    /**
     * Instantiates a new generic three drop down choices model.
     *
     * @param selectedOption the selected option
     * @param modelsMap the models map
     * @param selectedValuesChoices the selected values choices
     */
    public GenericThreeDropDownChoicesModel( final T selectedOption,
            final Map< T, List< T >> modelsMap,
            final List< T > selectedValuesChoices ) {
        super( selectedOption, modelsMap );
        this.selectedValuesChoices = selectedValuesChoices;
    }

    /**
     * Adds the selected value.
     *
     * @param selectedValue the selected value
     * @return true, if successful
     */
    public boolean addSelectedValue( final T selectedValue ) {
        List< T > selectedValues = getSelectedValuesChoicesObject();
        return selectedValues.add( selectedValue );
    }

    /**
     * Contains selected value.
     *
     * @param selectedValue the selected value
     * @return true, if successful
     */
    public boolean containsSelectedValue( final T selectedValue ) {
        return getSelectedValuesChoicesObject().contains( selectedValue );
    }

    /**
     * Gets the selected value option.
     *
     * @return the selected value option
     */
    public T getSelectedValueOption() {
        return selectedValueOption;
    }

    /**
     * Gets the selected values choices.
     *
     * @return the selected values choices
     */
    public List< T > getSelectedValuesChoices() {
        return selectedValuesChoices;
    }

    /**
     * Gets the selected values choices object.
     *
     * @return the selected values choices object
     */
    public List< T > getSelectedValuesChoicesObject() {
        return this.selectedValuesChoices;
    }

    /**
     * Removes the selected value.
     *
     * @param selectedValue the selected value
     * @return true, if successful
     */
    public boolean removeSelectedValue( final T selectedValue ) {
        List< T > selectedValues = getSelectedValuesChoicesObject();
        return selectedValues.remove( selectedValue );
    }

}
