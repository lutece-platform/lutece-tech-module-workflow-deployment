package fr.paris.lutece.plugins.workflow.modules.deployment.service;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import fr.paris.lutece.plugins.deployment.business.ISite;
import fr.paris.lutece.plugins.deployment.business.SiteTag;
import fr.paris.lutece.plugins.deployment.business.WorkflowDeploySiteContext;
import fr.paris.lutece.plugins.deployment.service.DeploymentPlugin;
import fr.paris.lutece.plugins.deployment.service.IWorkflowDeploySiteService;
import fr.paris.lutece.plugins.deployment.util.ConstanteUtils;
import fr.paris.lutece.plugins.workflowcore.business.resource.ResourceHistory;
import fr.paris.lutece.plugins.workflowcore.service.resource.IResourceHistoryService;
import fr.paris.lutece.plugins.workflowcore.service.task.SimpleTask;
import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;


public class TaskTag extends  SimpleTask {

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
        
    	
    	 String strSiteTagVersion = request.getParameter(ConstanteUtils.PARAM_SITE_TAG_VERSION );
         String strSiteNextVersion = request.getParameter( ConstanteUtils.PARAM_SITE_NEXT_VERSION );
         String strSiteTagName = request.getParameter( ConstanteUtils.PARAM_SITE_TAG_NAME);
        
    	
    	ResourceHistory resourceHistory = _resourceHistoryService.findByPrimaryKey( nIdResourceHistory );
    	WorkflowDeploySiteContext workflowDeploySiteContext=_workflowDeploySiteService.getWorkflowDeploySiteContext(resourceHistory.getIdResource());
         
        
    	
    	 workflowDeploySiteContext.setTagVersion(strSiteTagVersion);
    	 workflowDeploySiteContext.setNextVersion(strSiteNextVersion);
    	 workflowDeploySiteContext.setTagName(strSiteTagName);
        
        
    	 _workflowDeploySiteService.tagSite(workflowDeploySiteContext,locale);
        
        
        
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
