package com.saiproject.imageflip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewAnimator;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ViewFlipper viewFlipper;
    ImageButton btnNext;
    ImageButton btnPrev;
    ViewAnimator viewAnimator;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewFlipper = findViewById(R.id.viewFlipper);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrevious);
        viewAnimator = findViewById(R.id.viewAnimator);


        addImagesToViewFlipper(viewFlipper);
        addImagesToViewAnimator(viewAnimator);

        useAnimationViewFlipper(viewFlipper);
        useAnimationViewAnimator(viewAnimator);

        btnNext.setOnClickListener(MainActivity.this);
        btnPrev.setOnClickListener(MainActivity.this);





    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.btnNext:

                viewFlipper.showNext();
                viewAnimator.showNext();
                break;

            case R.id.btnPrevious:

                viewFlipper.showPrevious();
                viewAnimator.showPrevious();
                break;



        }

    }


    /*Set Layout Parameter to 500,500 */

    private void setLayoutParameter(ImageView imgView){

        imgView.setLayoutParams(new LinearLayout.LayoutParams(500,500));

    }


/*Add image to viewFlipper*/

    private void addImagesToViewFlipper(ViewFlipper viewFlipper) {


        for (int index = 0; index < Animal.animalImages.length; index++) {

            ImageView imgView = new ImageView(MainActivity.this);
            imgView.setImageResource(Animal.animalImages[index]);
            setLayoutParameter(imgView);
            imgView.setPadding(100, 100, 100, 100);

            viewFlipper.addView(imgView);

        }

    }

/*Add images to viewAnimator*/

    private void addImagesToViewAnimator(ViewAnimator viewAnimator) {


        for (int index = 0; index < Animal.animalImages.length; index++) {

            ImageView imgView = new ImageView(MainActivity.this);
            imgView.setImageResource(Animal.animalImages[index]);
            setLayoutParameter(imgView);
            imgView.setPadding(100, 100, 100, 100);

            viewAnimator.addView(imgView);

        }


    }


/* Add animation to viewFlipper slide in -> slide out */

    private void useAnimationViewFlipper(ViewFlipper viewFlipper){

            viewFlipper.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.slide_in_left));
            viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.slide_out_right));
    }


/*Add animation to viewAnimator fade in -> fadeout */

    private void useAnimationViewAnimator(ViewAnimator viewAnimator){

        viewAnimator.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.fade_in));
        viewAnimator.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.fade_out));

    }

}
