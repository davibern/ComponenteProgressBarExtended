package progressbar;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author davibern
 * @version 1.0
 */
public class ProgressBarPropertyEditorSupport extends PropertyEditorSupport {
    
    private ProgressBarPanel panel = new ProgressBarPanel();
    
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return panel;
    }

    @Override
    public String getJavaInitializationString() {
        Rangos rangos = panel.getSelectedValue();
        return ("new progressbar.Rangos(" + (int) rangos.getRango1() + ", " + (int) rangos.getRango2() + ")");
    }

    @Override
    public Object getValue() {
        return panel.getSelectedValue();
    }
    
}
