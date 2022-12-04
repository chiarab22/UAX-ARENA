package com.example.android.uaxarena;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMaps2Binding<FloatingActionButton> implements ViewBinding {
    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final FloatingActionButton mapbt7;

    private ActivityMaps2Binding(@NonNull RelativeLayout rootView,
                                 @NonNull FloatingActionButton mapbt7) {
        this.rootView = rootView;
        this.mapbt7 = mapbt7;
    }

    @Override
    @NonNull
    public RelativeLayout getRoot() {
        return rootView;
    }

    @NonNull
    public static ActivityMaps2Binding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    @NonNull
    public static ActivityMaps2Binding inflate(@NonNull LayoutInflater inflater,
                                               @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_mapa, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    @NonNull
    public static <FloatingActionButton> ActivityMaps2Binding bind(@NonNull View rootView) {
        // The body of this method is generated in a way you would not otherwise write.
        // This is done to optimize the compiled bytecode for size and performance.
        int id;
        missingId: {
            id = R.id.mapbt7;
            FloatingActionButton mapbt7 = ViewBindings.findChildViewById(rootView, id);
            if (mapbt7 == null) {
                break missingId;
            }

            return new ActivityMaps2Binding((RelativeLayout) rootView, mapbt7);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}
