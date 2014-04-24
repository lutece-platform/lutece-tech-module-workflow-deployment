/*
 * Copyright (c) 2002-2014, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.workflow.modules.deployment.service;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import fr.paris.lutece.plugins.deployment.service.IWorkflowDeploySiteService;
import fr.paris.lutece.plugins.deployment.util.ConstanteUtils;
import fr.paris.lutece.plugins.workflow.utils.WorkflowUtils;
import fr.paris.lutece.plugins.workflow.web.task.NoConfigTaskComponent;
import fr.paris.lutece.plugins.workflowcore.service.task.ITask;
import fr.paris.lutece.portal.service.i18n.I18nService;
import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.util.html.HtmlTemplate;


/**
 *
 * AlertTaskComponent
 *
 */
public class TaskDeployScript extends NoConfigTaskComponent
{

    private static final String TEMPLATE_TASK_DEPLOY_SCRIPT = "admin/plugins/workflow/modules/deployment/task_deploy_script_form.html";
    //Properties
    private static final String MESSAGE_MANDATORY_FIELD = "module.workflow.deployment.message.mandatory.field";
    private static final String PROPERTY_MANDATORY_FIELD_SCRIPT="module.workflow.deployment.task_deploy_script_form.label_script";
    private static final String PROPERTY_MANDATORY_FIELD_DATABASE="module.workflow.deployment.task_deploy_script_form.label_database";
    
	@Inject
    private IWorkflowDeploySiteService _workflowDeploySiteService;
	
	
	@Override
	public String doValidateTask(int nIdResource, String strResourceType,
			HttpServletRequest request, Locale locale, ITask task) {
		String strError = WorkflowUtils.EMPTY_STRING;
        String strScript = request.getParameter(ConstanteUtils.PARAM_SCRIPT );
             
        if(StringUtils.isBlank(strScript))
        {
        	strError=I18nService.getLocalizedString(PROPERTY_MANDATORY_FIELD_SCRIPT, locale);
        }
       
        
        if ( StringUtils.isNotBlank( strError ) )
        {
            Object[] tabRequiredFields = { strError };
            return I18nService.getLocalizedString(  MESSAGE_MANDATORY_FIELD, tabRequiredFields,locale);
        }

        return null;
	}

	@Override
	public String getDisplayTaskForm(int nIdResource, String strResourceType,
			HttpServletRequest request, Locale locale, ITask task) {
		
		
	
		Map<String, Object> model = new HashMap<String, Object>(  );
//        model.put( ConstanteUtils.MARK_SITE_TAG_VERSION, workflowDeploySiteContext.getTagVersion()  );
//		model.put( ConstanteUtils.MARK_SITE_NEXT_VERSION, workflowDeploySiteContext.getNextVersion()  );
//		model.put( ConstanteUtils.MARK_SITE_TAG_NAME, workflowDeploySiteContext.getTagName() );
//       
       
        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_TASK_DEPLOY_SCRIPT, locale, model );

        return template.getHtml(  );
	}

	@Override
	public String getDisplayTaskInformation(int nIdHistory,
			HttpServletRequest request, Locale locale, ITask task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTaskInformationXml(int nIdHistory,
			HttpServletRequest request, Locale locale, ITask task) {
		// TODO Auto-generated method stub
		return null;
	}
   
   

   

}
