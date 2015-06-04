package de.alpharogroup.wicket.behaviors.pnotify;

import java.util.Map;

import de.alpharogroup.wicket.base.util.template.JavascriptGenerator;

/**
 * The Class PnotifyJsGenerator generates the javascript with a PnotifySettings object.
 */
public class PnotifyJsGenerator extends JavascriptGenerator<PnotifySettings>
{

	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new {@link PnotifyJsGenerator}.
	 */
	public PnotifyJsGenerator()
	{
		this(new PnotifySettings());
	}

	/**
	 * Instantiates a new {@link PnotifyJsGenerator} with the given {@link PnotifySettings}.
	 *
	 * @param settings
	 *            the settings for the toastr plugin.
	 */
	public PnotifyJsGenerator(PnotifySettings settings)
	{
		super(settings);
		setMethodName("PNotify");
	}

	/**
	 * Generates the javascript template code from the given map and the given method name that will
	 * be used to interpolate with the values of the given map.
	 *
	 * @param variables
	 *            the map with the javascript options.
	 * @param methodName
	 *            The method name.
	 * @return The generated javascript from the given map and the given method name.
	 */
	public String generateJavascriptTemplateContent(final Map<String, Object> variables,
		String methodName)
	{
		StringBuilder sb = new StringBuilder();
		if (!getSettings().getStack().isInitialValue())
		{
			String customStack = "customStack";
			String stack = (String)variables.get("stack");
			sb.append("var " + customStack + " = ");
			sb.append(stack);
			sb.append(";\n");
			variables.put("stack", customStack);
		}
		sb.append("new");
		sb.append(" ");
		sb.append(methodName);
		sb.append("(");
		if (0 < variables.size())
		{
			sb.append("{\n");
			int count = 1;
			for (Map.Entry<String, Object> entry : variables.entrySet())
			{
				String key = entry.getKey();
				sb.append(key + ": ${" + key + "}");
				if (count < variables.size())
				{
					sb.append(",\n");
				}
				else
				{
					sb.append("\n");
				}
				count++;
			}
			sb.append("}");
		}
		sb.append(");");
		return sb.toString();
	}

}
