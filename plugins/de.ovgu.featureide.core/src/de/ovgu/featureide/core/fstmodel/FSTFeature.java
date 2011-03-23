/* FeatureIDE - An IDE to support feature-oriented software development
 * Copyright (C) 2005-2011  FeatureIDE Team, University of Magdeburg
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see http://www.gnu.org/licenses/.
 *
 * See http://www.fosd.de/featureide/ for further information.
 */
package de.ovgu.featureide.core.fstmodel;

import java.util.TreeMap;



/**
 * @author Constanze Adler
 * @author Tom Brosch
 * 
 */
public class FSTFeature extends FSTModelElement {
	
	private String name;
	
	public TreeMap<String, FSTClass> classes;
	
	public FSTFeature(String name) {
		this.name = name;
		classes = new TreeMap<String, FSTClass>();
	}

	public String getName() {
		return name;
	}

	public FSTModelElement[] getChildren() {
		if (classes == null) return null;
		FSTClass[] elements = new FSTClass[classes.size()];
		int i = 0;
		for (FSTClass c : classes.values())
			elements[i++] =  c;		
		return elements;
	}
}