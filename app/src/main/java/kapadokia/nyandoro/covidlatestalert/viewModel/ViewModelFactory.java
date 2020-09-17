package kapadokia.nyandoro.covidlatestalert.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Map;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

    @Inject
    public ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
        this.creators = creators;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Provider<? extends ViewModel> creator = creators.get(modelClass);

        if (creator==null){
            for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry:creators.entrySet()){
                if (modelClass.isAssignableFrom(entry.getKey())){
                    creator = entry.getValue();
                    break;
                }
            }
        }

        if (creator==null){
            throw new IllegalArgumentException("No Class Found"+ modelClass);
        }

        try {
            return (T)creator.get();
        }catch (Exception e){
         throw new RuntimeException(e);
        }

    }
}
