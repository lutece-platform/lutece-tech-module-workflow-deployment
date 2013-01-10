package fr.paris.lutece.plugins.workflow.modules.deployment.service;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import fr.paris.lutece.plugins.deployment.business.WorkflowDeploySiteContext;
import fr.paris.lutece.plugins.deployment.service.IWorkflowDeploySiteService;
import fr.paris.lutece.plugins.workflowcore.business.resource.ResourceHistory;
import fr.paris.lutece.plugins.workflowcore.service.resource.IResourceHistoryService;
import fr.paris.lutece.plugins.workflowcore.service.task.SimpleTask;


public class TaskAssemblySite extends  SimpleTask {

	@Inject
    private IResourceHistoryService _resourceHistoryService;
	@Inject
    private IWorkflowDeploySiteService _workflowDeploySiteService;
	
    /**
     * {@inheritDoc}
     */
    @Override
    public void processTask( int nIdResourceHistory, HttpServletRequest request, Locale locale )
    {
        ResourceHistory resourceHistory = _resourceHistoryService.findByPrimaryKey( nIdResourceHistory );
        WorkflowDeploySiteContext workflowDeploySiteContext=_workflowDeploySiteService.getWorkflowDeploySiteContext(resourceHistory.getIdResource());
       _workflowDeploySiteService.assemblySite(workflowDeploySiteContext,locale);
        	
        
        
        

    }

    /**
    * {@inheritDoc}
    */
    @Override
    public String getTitle( Locale locale )
    {
        return StringUtils.EMPTY;
    }
	
	

}
