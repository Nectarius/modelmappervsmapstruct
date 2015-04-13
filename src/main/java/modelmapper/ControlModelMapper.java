package modelmapper;

import domain.Control;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import view.ControlView;

import java.lang.reflect.Type;

/**
 * Created by adelfiri on 4/11/15.
 */
public class ControlModelMapper extends ModelMapper {

    private Boolean isEmployee = false;

    public Boolean getIsEmployee() {
        return isEmployee;
    }

    public ControlView controlToControlView(Control control, Boolean isEmployee) {

        this.isEmployee = isEmployee;
        Type type = new TypeToken<ControlView>() {

        }.getType();
        return super.map(control, type);

    }
}
