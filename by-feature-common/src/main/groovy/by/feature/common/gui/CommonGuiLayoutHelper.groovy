package by.feature.common.gui

class CommonGuiLayoutHelper implements IGuiLayoutHelper {



    protected String templateRootPath

    String getTemplateRootPath() {
        return templateRootPath
    }

    void setTemplateRootPath(String templateRootPath) {
        this.templateRootPath = templateRootPath.concat("/")
    }




    @Override
    String getAbsolutePathFor(String templateOrViewPath) {
        return this.templateRootPath.concat(templateOrViewPath)
    }



}
