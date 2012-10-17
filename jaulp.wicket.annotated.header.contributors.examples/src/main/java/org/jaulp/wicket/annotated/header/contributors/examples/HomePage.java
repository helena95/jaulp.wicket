package org.jaulp.wicket.annotated.header.contributors.examples;

import org.jaulp.wicket.base.BasePage;
import org.jaulp.wicket.annotated.header.contributors.examples.panels.footer.FooterPanel;
import org.jaulp.wicket.annotated.header.contributors.examples.panels.home.HomePanel;

import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Homepage
 */
public class HomePage extends BasePage {

	private static final long serialVersionUID = 1L;

    /**
	 * Constructor that is invoked when page is invoked without a session.
	 *
	 * @param parameters
	 *            Page parameters
	 */
    public HomePage(final PageParameters parameters) {
    	super(parameters);

    	add(new HomePanel("homePanel"));

    	add(new FooterPanel("footerPanel"));

    }

}