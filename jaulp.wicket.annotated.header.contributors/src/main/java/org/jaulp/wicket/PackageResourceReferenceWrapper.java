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
package org.jaulp.wicket;

import org.apache.wicket.request.resource.PackageResourceReference;
import org.jaulp.wicket.base.enums.ResourceReferenceType;

/**
 * The Class PackageResourceReferenceWrapper.
 */
public class PackageResourceReferenceWrapper {

	/** The package resource reference. */
	private final PackageResourceReference packageResourceReference;

	/** The type. */
	private final ResourceReferenceType type;

	/**
	 * The Constructor.
	 *
	 * @param packageResourceReference the package resource reference
	 * @param type the type
	 */
	public PackageResourceReferenceWrapper(PackageResourceReference packageResourceReference, ResourceReferenceType type) {
		super();
		this.packageResourceReference = packageResourceReference;
		this.type = type;
	}

	/**
	 * Gets the package resource reference.
	 *
	 * @return the package resource reference
	 */
	public PackageResourceReference getPackageResourceReference() {
		return packageResourceReference;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public ResourceReferenceType getType() {
		return type;
	}

}
