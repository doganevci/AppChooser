package doganevci.appchooser.Utils;


import android.view.View;

import com.eftimoff.viewpagertransformers.BaseTransformer;

/**
 * Created by doganevci on 15/09/2017.
 */

public class MyAnimationTrans extends BaseTransformer{
    private static final float MIN_SCALE = 0.75F;

    @Override
    protected void onPreTransform(View view, float position) {


    }

    @Override
    protected void onTransform(View view, float position) {

        if(position <= 0.0F) {
            view.setTranslationX(0.0F);
            view.setScaleX(1.0F);
            view.setScaleY(1.0F);
        } else if(position <= 1.0F) {
            float scaleFactor = 0.75F + 0.25F * (1.0F - Math.abs(position));
            view.setAlpha(1.0F - position);
            view.setPivotY(0.5F * (float)view.getHeight());
            view.setTranslationX((float)view.getWidth() * -position);
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        }

    }

    @Override
    protected void onPostTransform(View view, float position) {


    }

    protected boolean isPagingEnabled() {
        return true;
    }
}
