/* FeatureIDE - A Framework for Feature-Oriented Software Development
 * Copyright (C) 2005-2016  FeatureIDE team, University of Magdeburg, Germany
 *
 * This file is part of FeatureIDE.
 * 
 * FeatureIDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * FeatureIDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with FeatureIDE.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See http://featureide.cs.ovgu.de/ for further information.
 */
package de.ovgu.featureide.fm.ui.editors.featuremodel.actions;

import static de.ovgu.featureide.fm.core.localization.StringTable.HIDE_LEGEND;
import static de.ovgu.featureide.fm.core.localization.StringTable.SHOW_LEGEND;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gef.ui.parts.GraphicalViewerImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;

import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.ui.FMUIPlugin;
import de.ovgu.featureide.fm.ui.editors.featuremodel.operations.HideLegendOperation;
import de.ovgu.featureide.fm.ui.properties.FMPropertyManager;

/**
 * Shows/hides the legend when executed.
 * 
 * @author Fabian Benduhn
 * @author Marcus Pinnecke
 */
public class LegendAction extends Action {

	private final IFeatureModel featureModel;

	public LegendAction(GraphicalViewerImpl viewer, IFeatureModel featureModel) {
		super();
		this.featureModel = featureModel;
		if (!FMPropertyManager.isLegendHidden()) {
			this.setText(HIDE_LEGEND);
		} else {
			this.setText(SHOW_LEGEND);
		}

	}

	@Override
	public void run() {
		HideLegendOperation op = new HideLegendOperation(featureModel);

		try {
			PlatformUI.getWorkbench().getOperationSupport().getOperationHistory().execute(op, null, null);
		} catch (ExecutionException e) {
			FMUIPlugin.getDefault().logError(e);
		}
		refresh();
	}

	public void refresh() {
		if (!FMPropertyManager.isLegendHidden()) {
			this.setText(HIDE_LEGEND);
		} else {
			this.setText(SHOW_LEGEND);
		}
	}
}
