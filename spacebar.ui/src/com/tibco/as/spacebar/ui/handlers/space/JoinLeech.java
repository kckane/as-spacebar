package com.tibco.as.spacebar.ui.handlers.space;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.progress.UIJob;

import com.tibco.as.spacebar.ui.SpaceBarPlugin;
import com.tibco.as.spacebar.ui.model.Space;

public class JoinLeech extends AbstractSpaceHandler {

	@Override
	protected void handle(ExecutionEvent event, final Space space) {
		Shell shell = HandlerUtil.getActiveShell(event);
		new UIJob(shell.getDisplay(), "JoinLeech") {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				try {
					monitor.beginTask(
							NLS.bind("Joining space ''{0}'' as leech", space),
							1);
					space.joinLeech();
					monitor.worked(1);
				} catch (com.tibco.as.space.ASException e) {
					return new Status(IStatus.ERROR, SpaceBarPlugin.ID_PLUGIN,
							NLS.bind("Could not join space ''{0}'' as leech",
									space), e);
				} finally {
					monitor.done();
				}
				return Status.OK_STATUS;
			}
		}.schedule();
	}

}
