package com.borregobrothers.jrose.antibioticornot;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;


public class QuestionnaireOneActivity extends AppCompatActivity {

    private final static String TAG = " Look for StUpId --> ";

    // Make all checkboxes global within the class
    // Checkboxes for "yes" and "no" of the main questions
    private CheckBox feverYes, feverNo, coughYes, coughNo, soreThroatHoarsenessYes, soreThroatHoarsenessNo,
            whitePatchesYes, whitePatchesNo, facialPainYes, facialPainNo, bodyAcheYes, bodyAcheNo, sneezingYes, sneezingNo, nasalCongestionYes, nasalCongestionNo,
            nasalDischargeYes, nasalDischargeNo, postNasalDripYes, postNasalDripNo, shortnessOfBreathWheezingYes, shortnessOfBreathWheezingNo,
            chestPainYes, chestPainNo, neckStiffnessYes, neckStiffnessNo, tenderLymphNodesYes, tenderLymphNodesNo, headacheYes, headacheNo, preExistingConditionsYes,
            preExistingConditionsNo, symptomsLessThanSevenDays, symptomsMoreThanSevenDays;

    // Checkboxes for the fever dialog
    private CheckBox lowFeverRange, highFeverRange;

    // Checkboxes for the nasal discharge dialog
    private CheckBox colorClear, colorYellowGreen;

    // Checkboxes for pre-existing conditions
    private CheckBox pregnantOrTwoWeeksPostpartum, cancer, copd, cad, hiv, aids, recentUseOfAntibiotic, recentHospitalization, autoimmuneDisease, chronicSteroidUse;

    // Make a ArrayList to hold all the values of the selected checkboxes
    private ArrayList<CheckBox> selectedCheckBox = new ArrayList<CheckBox>();
    private ArrayList<CheckBox> notSelectedCheckBox = new ArrayList<CheckBox>();

    private Stack<CheckBox> selectedCheckBoxStack = new Stack<CheckBox>();
    private Stack<CheckBox> notSelectedCheckBoxStack = new Stack<CheckBox>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_one_layout);

        /*
                The listener method displays the fever alert dialog if the "yes" checkbox for
                fever is selected. The method also disables both the "yes" and "no" checkboxes
                and adds "yes" to the selectedCheckBox list.
         */
        feverYes = (CheckBox) findViewById(R.id.feverYes);
        assert feverYes != null;
        feverYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                feverDialog();
                disable(feverYes, feverNo);
                selectedCheckBox.add(feverYes);
                notSelectedCheckBox.add(feverNo);

                selectedCheckBoxStack.push(feverYes);
                notSelectedCheckBoxStack.push(feverNo);
            }
        });

        /*
                The listener method disables both the "yes" and  "no" checkboxes if
                the fever "no" checkbox is selected  and adds "no" to the selectedCheckBox list.
         */
        feverNo = (CheckBox) findViewById(R.id.feverNo);
        assert feverNo != null;
        feverNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(feverYes,feverNo);
                selectedCheckBox.add(feverNo);
                notSelectedCheckBox.add(feverYes);

                selectedCheckBoxStack.push(feverNo);
                notSelectedCheckBoxStack.push(feverYes);
            }
        });


        /*
                The listener method disables the "yes" and "no" checkboxes if the cough "yes"
                checkbox is selected and adds "yes" to the selectedCheckBox list.
         */
        coughYes = (CheckBox) findViewById(R.id.coughYes);
        assert coughYes != null;
        coughYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(coughYes, coughNo);
                selectedCheckBox.add(coughYes);
                notSelectedCheckBox.add(coughNo);

                selectedCheckBoxStack.push(coughYes);
                notSelectedCheckBoxStack.push(coughNo);
            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the cough "no" checkbox is selected and adds "no" to the selectedCheckBox list.
         */
        coughNo = (CheckBox) findViewById(R.id.coughNo);
        assert coughNo != null;
        coughNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(coughYes,coughNo);
                selectedCheckBox.add(coughNo);
                notSelectedCheckBox.add(coughYes);

                selectedCheckBoxStack.push(coughNo);
                notSelectedCheckBoxStack.push(coughYes);
            }
        });


        /*
                The listener method disables the "yes" and "no" checkboxes if the sore throat
                 hoarseness "yes" checkbox is selected and adds "yes" to the selectedCheckBox list.
         */
        soreThroatHoarsenessYes = (CheckBox) findViewById(R.id.soreThroatHoarsenessYes);
        assert soreThroatHoarsenessYes != null;
        soreThroatHoarsenessYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(soreThroatHoarsenessYes, soreThroatHoarsenessNo);
                selectedCheckBox.add(soreThroatHoarsenessYes);
                notSelectedCheckBox.add(soreThroatHoarsenessNo);

                selectedCheckBoxStack.push(soreThroatHoarsenessYes);
                notSelectedCheckBoxStack.push(soreThroatHoarsenessNo);
            }
        });

        /*
                The listener method disable both the "yes" and the "no" checkbox if
                the sore throat hoarseness "no" checkbox is selected and adds "no"
                to the selectedCheckBox list.
         */
        soreThroatHoarsenessNo = (CheckBox) findViewById(R.id.soreThroatHoarsenessNo);
        assert soreThroatHoarsenessNo != null;
        soreThroatHoarsenessNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(soreThroatHoarsenessYes, soreThroatHoarsenessNo);
                selectedCheckBox.add(soreThroatHoarsenessNo);
                notSelectedCheckBox.add(soreThroatHoarsenessYes);

                selectedCheckBoxStack.push(soreThroatHoarsenessNo);
                notSelectedCheckBoxStack.push(soreThroatHoarsenessYes);
            }
        });

        /*
                The listener method disables the "yes" and "no" checkboxes if the white patches
                "yes" checkbox is selected and adds "yes" to the selectedCheckBox list.
         */
        whitePatchesYes = (CheckBox) findViewById(R.id.whitePatchesInThroatYes);
        assert whitePatchesYes != null;
        whitePatchesYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(whitePatchesYes, whitePatchesNo);
                selectedCheckBox.add(whitePatchesYes);
                notSelectedCheckBox.add(whitePatchesNo);

                selectedCheckBoxStack.push(whitePatchesYes);
                notSelectedCheckBoxStack.push(whitePatchesNo);
            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the white patches "no" checkbox is selected and adds "no" to the selectedCheckBox list.
         */
        whitePatchesNo = (CheckBox) findViewById(R.id.whitePatchesInThroatNo);
        assert whitePatchesNo != null;
        whitePatchesNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(whitePatchesYes, whitePatchesNo);
                selectedCheckBox.add(whitePatchesNo);
                notSelectedCheckBox.add(whitePatchesYes);

                selectedCheckBoxStack.push(whitePatchesNo);
                notSelectedCheckBoxStack.push(whitePatchesYes);

            }
        });


        /*
                The listener method disables the "yes" and "no" checkboxes if the facial pain "yes"
                checkbox is selected and adds "yes" to the selectedCheckBox list.
         */
        facialPainYes = (CheckBox) findViewById(R.id.facialPainYes);
        assert facialPainYes != null;
        facialPainYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(facialPainYes, facialPainNo);
                selectedCheckBox.add(facialPainYes);
                notSelectedCheckBox.add(facialPainNo);

                selectedCheckBoxStack.push(facialPainYes);
                notSelectedCheckBoxStack.push(facialPainNo);
            }
        });

        /*
                The listener method disable both the "yes" and the "no" checkbox if
                the facial pain "no" checkbox is selected and adds "no" to the selectedCheckBox list.
         */
        facialPainNo = (CheckBox) findViewById(R.id.facialPainNo);
        assert facialPainNo!= null;
        facialPainNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(facialPainYes,facialPainNo);
                selectedCheckBox.add(facialPainNo);
                notSelectedCheckBox.add(facialPainYes);

                selectedCheckBoxStack.push(facialPainNo);
                notSelectedCheckBoxStack.push(facialPainYes);
            }
        });

        /*
                The listener method disables the "yes" and "no" checkboxes if the body
                ache "yes" checkbox is selected and adds "yes" to the selectedCheckBox list.
         */
        bodyAcheYes = (CheckBox) findViewById(R.id.bodyAcheYes);
        assert bodyAcheYes != null;
        bodyAcheYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(bodyAcheYes, bodyAcheNo);
                selectedCheckBox.add(bodyAcheYes);
                notSelectedCheckBox.add(bodyAcheNo);

                selectedCheckBoxStack.push(bodyAcheYes);
                notSelectedCheckBoxStack.push(bodyAcheNo);
            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the body ache "no" checkbox is selected and adds "no" to the selectedCheckBox list.
         */
        bodyAcheNo = (CheckBox) findViewById(R.id.bodyAcheNo);
        assert bodyAcheNo != null;
        bodyAcheNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(bodyAcheYes, bodyAcheNo);
                selectedCheckBox.add(bodyAcheNo);
                notSelectedCheckBox.add(bodyAcheYes);

                selectedCheckBoxStack.push(bodyAcheYes);
                notSelectedCheckBoxStack.push(bodyAcheNo);
            }
        });

        /*
                The listener method disables the "yes" and "no" checkboxes if the sneezing "yes"
                checkbox is selected and adds "yes" to the selectedCheckBox list.
         */
        sneezingYes = (CheckBox) findViewById(R.id.sneezingYes);
        assert sneezingYes != null;
        sneezingYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(sneezingYes, sneezingNo);
                selectedCheckBox.add(sneezingYes);
                notSelectedCheckBox.add(sneezingNo);

                selectedCheckBoxStack.push(sneezingYes);
                notSelectedCheckBoxStack.push(sneezingNo);
            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the sneezing "no" checkbox is selected and adds "no" to the selectedCheckBox list.
         */
        sneezingNo = (CheckBox) findViewById(R.id.sneezingNo);
        assert sneezingNo != null;
        sneezingNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(sneezingYes, sneezingNo);
                selectedCheckBox.add(sneezingNo);
                notSelectedCheckBox.add(sneezingYes);

                selectedCheckBoxStack.push(sneezingYes);
                notSelectedCheckBoxStack.push(sneezingNo);
            }
        });

          /*
            The listener method disables both the "yes" and the "no" checkbox if
            nasal congestion "yes" checkbox is selected and adds "yes" to the selectedCheckBox list.
         */
        nasalCongestionYes = (CheckBox) findViewById(R.id.nasalCongestionYes);

        assert nasalCongestionYes != null;
        nasalCongestionYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Nasal Congestion Yes Checkbox was Selected!");

                disable(nasalCongestionYes,nasalCongestionNo);
                selectedCheckBox.add(nasalCongestionYes);
                notSelectedCheckBox.add(nasalCongestionNo);

                selectedCheckBoxStack.push(nasalCongestionYes);
                notSelectedCheckBoxStack.push(nasalCongestionNo);
            }
        });

        /*
            The listener method disables both the "yes" and the "no" checkbox if
            nasal congestion "no" checkbox is selected and adds "no" to the selectedCheckBox list.
         */
        nasalCongestionNo = (CheckBox) findViewById(R.id.nasalCongestionNo);
        assert nasalCongestionNo != null;
        nasalCongestionNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(nasalCongestionYes,nasalCongestionNo);
                selectedCheckBox.add(nasalCongestionNo);
                notSelectedCheckBox.add(nasalCongestionYes);

                selectedCheckBoxStack.push(nasalCongestionNo);
                notSelectedCheckBoxStack.push(nasalCongestionYes);
            }
        });

        /*
                The listener method displays an alert dialog if the "yes" checkbox for
                nasal discharge is selected.  The method also disables both the "yes" and "no" checkboxes
                and adds "yes" to the selectedCheckBox list.
         */
        nasalDischargeYes = (CheckBox) findViewById(R.id.nasalDischargeYes);

        assert nasalDischargeYes != null;
        nasalDischargeYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Nasal Discharge Yes Checkbox was Selected!");
                nasalDischargeColorDialog();
                disable(nasalDischargeYes,nasalDischargeNo);
                selectedCheckBox.add(nasalDischargeYes);
                notSelectedCheckBox.add(nasalDischargeNo);

                selectedCheckBoxStack.push(nasalDischargeYes);
                notSelectedCheckBoxStack.push(nasalDischargeNo);
            }
        });

        /*
            The listener method disables both the "yes" and the "no" checkbox if
            nasal discharge "no" checkbox is selected and adds "no" to the selectedCheckBox list.
         */
        nasalDischargeNo = (CheckBox) findViewById(R.id.nasalDischargeNo);
        assert nasalDischargeNo != null;
        nasalDischargeNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(nasalDischargeYes,nasalDischargeNo);
                selectedCheckBox.add(nasalDischargeNo);
                notSelectedCheckBox.add(nasalDischargeYes);

                selectedCheckBoxStack.push(nasalDischargeNo);
                notSelectedCheckBoxStack.push(nasalDischargeYes);
            }
        });

         /*
                The listener method disables the "yes" and "no" checkboxes if the post
                nasal drip "yes" checkbox is selected and adds "yes" to the selectedCheckBox list.
         */
        postNasalDripYes = (CheckBox) findViewById(R.id.postNasalDripYes);
        assert postNasalDripYes != null;
        postNasalDripYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(postNasalDripYes, postNasalDripNo);
                selectedCheckBox.add(postNasalDripYes);
                notSelectedCheckBox.add(postNasalDripNo);

                selectedCheckBoxStack.push(postNasalDripYes);
                notSelectedCheckBoxStack.push(postNasalDripNo);
            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the post nasal drip "no" checkbox is selected and adds "no" to the selectedCheckBox list.
         */
        postNasalDripNo = (CheckBox) findViewById(R.id.postNasalDripNo);
        assert postNasalDripNo != null;
        postNasalDripNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(postNasalDripYes, postNasalDripNo);
                selectedCheckBox.add(postNasalDripNo);
                notSelectedCheckBox.add(postNasalDripYes);

                selectedCheckBoxStack.push(postNasalDripNo);
                notSelectedCheckBoxStack.push(postNasalDripYes);
            }
        });

         /*
                The listener method disables the "yes" and "no" checkboxes if the shortness
                 of breath or wheezing "yes" checkbox is selected and adds "yes" to the selectedCheckBox list.
         */
        shortnessOfBreathWheezingYes = (CheckBox) findViewById(R.id.shortnessOfBreathWheezingYes);
        assert shortnessOfBreathWheezingYes != null;
        shortnessOfBreathWheezingYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(shortnessOfBreathWheezingYes, shortnessOfBreathWheezingNo);
                selectedCheckBox.add(shortnessOfBreathWheezingYes);
                notSelectedCheckBox.add(shortnessOfBreathWheezingNo);

                selectedCheckBoxStack.push(shortnessOfBreathWheezingYes);
                notSelectedCheckBoxStack.push(shortnessOfBreathWheezingNo);
            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the shortness of breath or wheezing "no" checkbox is selected and adds
                "no" to the selectedCheckBox list.
         */
        shortnessOfBreathWheezingNo = (CheckBox) findViewById(R.id.shortnessOfBreathWheezingNo);
        assert shortnessOfBreathWheezingNo != null;
        shortnessOfBreathWheezingNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(shortnessOfBreathWheezingYes, shortnessOfBreathWheezingNo);
                selectedCheckBox.add(shortnessOfBreathWheezingNo);
                notSelectedCheckBox.add(shortnessOfBreathWheezingYes);

                selectedCheckBoxStack.push(shortnessOfBreathWheezingNo);
                notSelectedCheckBoxStack.push(shortnessOfBreathWheezingYes);
            }
        });


        /*
                The listener method disables the "yes" and "no" checkboxes if the chest pains "yes"
                checkbox is selected and adds "yes" to the selectedCheckBox list.
         */
        chestPainYes = (CheckBox) findViewById(R.id.chestPainYes);
        assert chestPainYes != null;
        chestPainYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(chestPainYes, chestPainNo);
                selectedCheckBox.add(chestPainYes);
                notSelectedCheckBox.add(chestPainNo);

                selectedCheckBoxStack.push(chestPainYes);
                notSelectedCheckBoxStack.push(chestPainNo);
            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the chest pain "no" checkbox is selected and adds "no" to the selectedCheckBox list.
         */
        chestPainNo = (CheckBox) findViewById(R.id.chestPainNo);
        assert chestPainNo != null;
        chestPainNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(chestPainYes, chestPainNo);
                selectedCheckBox.add(chestPainNo);
                notSelectedCheckBox.add(chestPainYes);

                selectedCheckBoxStack.push(chestPainNo);
                notSelectedCheckBoxStack.push(chestPainYes);
            }
        });

        /*
                The listener method disables the "yes" and "no" checkboxes if the neck
                stiffness "yes" checkbox is selected and adds "yes" to the selectedCheckBox list.
         */
        neckStiffnessYes = (CheckBox) findViewById(R.id.neckStiffnessYes);
        assert neckStiffnessYes != null;
        neckStiffnessYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(neckStiffnessYes, neckStiffnessNo);
                selectedCheckBox.add(neckStiffnessYes);
                notSelectedCheckBox.add(neckStiffnessNo);

                selectedCheckBoxStack.push(neckStiffnessYes);
                notSelectedCheckBoxStack.push(neckStiffnessNo);
            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the neckStiffness "no" checkbox is selected and adds "no" to the selectedCheckBox list.
         */
        neckStiffnessNo = (CheckBox) findViewById(R.id.neckStiffnessNo);
        assert neckStiffnessNo != null;
        neckStiffnessNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(neckStiffnessYes, neckStiffnessNo);
                selectedCheckBox.add(neckStiffnessNo);
                notSelectedCheckBox.add(neckStiffnessYes);

                selectedCheckBoxStack.push(neckStiffnessNo);
                notSelectedCheckBoxStack.push(neckStiffnessYes);
            }
        });

                /*
                The listener method disables the "yes" and "no" checkboxes if the neck
                stiffness "yes" checkbox is selected and adds "yes" to the selectedCheckBox list.
         */
        tenderLymphNodesYes = (CheckBox) findViewById(R.id.tenderLymphNodesYes);
        assert tenderLymphNodesYes != null;
        tenderLymphNodesYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(tenderLymphNodesYes, tenderLymphNodesNo);
                selectedCheckBox.add(tenderLymphNodesYes);
                notSelectedCheckBox.add(tenderLymphNodesNo);

                selectedCheckBoxStack.push(tenderLymphNodesYes);
                notSelectedCheckBoxStack.push(tenderLymphNodesNo);
            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the neckStiffness "no" checkbox is selected and adds "no" to the selectedCheckBox list.
         */
        tenderLymphNodesNo = (CheckBox) findViewById(R.id.tenderLymphNodesNo);
        assert tenderLymphNodesNo != null;
        tenderLymphNodesNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(tenderLymphNodesYes, tenderLymphNodesNo);
                selectedCheckBox.add(tenderLymphNodesNo);
                notSelectedCheckBox.add(tenderLymphNodesYes);

                selectedCheckBoxStack.push(tenderLymphNodesNo);
                notSelectedCheckBoxStack.push(tenderLymphNodesYes);
            }
        });

        /*
                The listener method disables the "yes" and "no" checkboxes if the fatigue "yes"
                checkbox is selected and adds "yes" to the selectedCheckBox list.
         */
        headacheYes = (CheckBox) findViewById(R.id.headacheYes);
        assert headacheYes != null;
        headacheYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(headacheYes, headacheNo);
                selectedCheckBox.add(headacheYes);
                notSelectedCheckBox.add(headacheNo);

                selectedCheckBoxStack.push(headacheYes);
                notSelectedCheckBoxStack.push(headacheNo);
            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the cough "no" checkbox is selected and adds "no" to the selectedCheckBox list.
         */
        headacheNo = (CheckBox) findViewById(R.id.headacheNo);
        assert headacheNo != null;
        headacheNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(headacheYes, headacheNo);
                selectedCheckBox.add(headacheNo);
                notSelectedCheckBox.add(headacheYes);

                selectedCheckBoxStack.push(headacheNo);
                notSelectedCheckBoxStack.push(headacheYes);
            }
        });

        /*
                The listener method displays an alert dialog if the "yes" checkbox for
                pre-existing conditions is selected. Both the yes and no checkboxes will be disabled when one is selected.
         */

        preExistingConditionsYes = (CheckBox) findViewById(R.id.preExistingConditionsYes);
        assert preExistingConditionsYes != null;
        preExistingConditionsYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Pre-existing Conditions Yes Checkbox was Selected!");
                preExistingConditionDialog();
                disable(preExistingConditionsYes, preExistingConditionsNo);
                selectedCheckBox.add(preExistingConditionsYes);
                notSelectedCheckBox.add(preExistingConditionsNo);

                selectedCheckBoxStack.push(preExistingConditionsYes);
                notSelectedCheckBoxStack.push(preExistingConditionsNo);

            }
        });

        preExistingConditionsNo = (CheckBox) findViewById(R.id.preExistingConditionsNo);
        assert preExistingConditionsNo != null;
        preExistingConditionsNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable(preExistingConditionsYes, preExistingConditionsNo);
                selectedCheckBox.add(preExistingConditionsNo);
                notSelectedCheckBox.add(preExistingConditionsYes);


                selectedCheckBoxStack.push(preExistingConditionsNo);
                notSelectedCheckBoxStack.push(preExistingConditionsYes);
            }
        });

        // Symptoms length of time
        symptomsLessThanSevenDays = (CheckBox) findViewById(R.id.lessThanSevenDays);
        assert symptomsLessThanSevenDays!= null;
        symptomsLessThanSevenDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Pre-existing Conditions Yes Checkbox was Selected!");
                disable(symptomsLessThanSevenDays, symptomsMoreThanSevenDays);

                selectedCheckBox.add(symptomsLessThanSevenDays);
                notSelectedCheckBox.add(symptomsMoreThanSevenDays);

                selectedCheckBoxStack.push(symptomsLessThanSevenDays);
                notSelectedCheckBoxStack.push(symptomsMoreThanSevenDays);
            }
        });

        // Symptoms length of time
        symptomsMoreThanSevenDays = (CheckBox) findViewById(R.id.moreThanSevenDays);
        assert symptomsMoreThanSevenDays!= null;
        symptomsMoreThanSevenDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Pre-existing Conditions Yes Checkbox was Selected!");
                disable(symptomsLessThanSevenDays, symptomsMoreThanSevenDays);

                selectedCheckBox.add(symptomsMoreThanSevenDays);
                notSelectedCheckBox.add(symptomsLessThanSevenDays);

                selectedCheckBoxStack.push(symptomsMoreThanSevenDays);
                notSelectedCheckBoxStack.push(symptomsLessThanSevenDays);
            }
        });


        /*
                Create "resultButton" to display the appropriate result screen
                based on the checkbox selections made.
         */
        Button resultButton = (Button) findViewById(R.id.resultButton);
        assert resultButton != null;
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Prompt the user to  make sure the selections made are the correct answers
                selectionConformationDialog();
                Log.v(TAG, "The result button was clicked!");
;
            }
        });

    } // Closes the onCreate method


    /*
            This method creates a dialog to prompt the user to confirm the selections made.
            The "yes" button will simply exit the dialog and the "no" button will reset will
            reset all checkboxes. The selectedCheckBox list will be emptied as well.
     */
    private void selectionConformationDialog() {
        final Dialog selectionConformationDialog = new Dialog(this);
        selectionConformationDialog.setContentView(R.layout.dialog_selection_conformation_layout);
        selectionConformationDialog.setTitle(R.string.selection_dialog_title_text);
        selectionConformationDialog.show();

        Button yesButton, noButton;

        yesButton = (Button) selectionConformationDialog.findViewById(R.id.yesButton);
        assert yesButton != null;
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Debug Stuff --> --> --> // Debug Stuff --> --> -->
                Log.v(TAG, "This is the selected checkbox list:");
                printSelectionList(selectedCheckBox);
                Log.v(TAG, "This is the not selected list");
                printSelectionList(notSelectedCheckBox);

                Log.v(TAG, "This is the selected checkbox stack:");
                printSelectionStack(selectedCheckBoxStack);
                Log.v(TAG, "This is the not selected stack");
                printSelectionStack(notSelectedCheckBoxStack);


                /*
                    User is happy with selections made and confirms them
                    Display the correct result screen based on the options chosen by the user
                */

                int numberOfItemsInList = selectedCheckBox.size();
                switch (numberOfItemsInList) {

                    case 1:
                        // Create "onlySelectionMade" CheckBox and assign it to the first item in the list
                        CheckBox onlySelectionMade = selectedCheckBox.get(0);

                        // Definitely yes for further evaluation
                        if (onlySelectionMade.equals(preExistingConditionsYes)) {

                            selectionConformationDialog.dismiss();
                            resultYesDialog();
                        }

                        // Definitely no antibiotic
                        if (onlySelectionMade.equals(nasalCongestionYes)
                                || onlySelectionMade.equals(postNasalDripYes)
                                || onlySelectionMade.equals(coughYes)
                                || onlySelectionMade.equals(soreThroatHoarsenessYes)
                                || onlySelectionMade.equals(headacheYes)
                                || onlySelectionMade.equals(facialPainYes)
                                || onlySelectionMade.equals(bodyAcheYes)
                                || onlySelectionMade.equals(feverNo) ) {

                            selectionConformationDialog.dismiss();
                            resultNoDialog();
                        }
                        break;

                    case 2:

                        // Definitely yes for further evaluation
                        if ((selectedCheckBox.contains(feverYes) && selectedCheckBox.contains(highFeverRange)) ) {

                            selectionConformationDialog.dismiss();
                            resultYesDialog();
                        }

                        // Definitely no antibiotic
                        if ((selectedCheckBox.contains(feverNo) && selectedCheckBox.contains(nasalCongestionYes))
                                || (selectedCheckBox.contains(soreThroatHoarsenessYes) && selectedCheckBox.contains(nasalCongestionYes))
                                || (selectedCheckBox.contains(soreThroatHoarsenessYes) && selectedCheckBox.contains(coughYes))
                                || (selectedCheckBox.contains(coughYes) && selectedCheckBox.contains(nasalCongestionYes))
                                || (selectedCheckBox.contains(coughYes) && selectedCheckBox.contains(sneezingYes))) {

                            selectionConformationDialog.dismiss();
                            resultNoDialog();
                        }

                        break;
                    case 3:

                }

                /*
                if (itemsInCheckBoxList == 1) {

                    // Create "onlySelectionMade" CheckBox and assign it to the first item in the list
                    CheckBox onlySelectionMade = selectedCheckBox.get(0);

                    // Definitely no antibiotic
                    if (onlySelectionMade.equals(nasalCongestionYes)
                            || onlySelectionMade.equals(coughYes)
                            || onlySelectionMade.equals(soreThroatHoarsenessYes)
                            || onlySelectionMade.equals(headacheYes)
                            || onlySelectionMade.equals(facialPainYes)
                            || onlySelectionMade.equals(bodyAcheYes)) {

                        selectionConformationDialog.dismiss();
                        resultNoDialog();
                    }

                }
                */
            }
        });

        noButton = (Button) selectionConformationDialog.findViewById(R.id.noButton);
        assert noButton != null;
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // User is not happy with selections so all check boxes are reset
                for (CheckBox selected : selectedCheckBox) {
                    selected.setEnabled(true);
                    selected.setChecked(false);
                }

                for (CheckBox notSelected : notSelectedCheckBox) {
                    notSelected.setEnabled(true);
                    notSelected.setChecked(false);
                }

                // The selected checkbox list and not selected checkbox list need to be cleared
                selectedCheckBox = new ArrayList<CheckBox>();
                notSelectedCheckBox = new ArrayList<CheckBox>();

                selectedCheckBoxStack = new Stack<CheckBox>();
                notSelectedCheckBoxStack = new Stack<CheckBox>();

                selectionConformationDialog.dismiss();

            }
        });
    } // Closes the selection conformation Dialog


    private void resultNoDialog() {
        final Dialog resultNoDialog = new Dialog(this);
        resultNoDialog.setContentView(R.layout.dialog_result_no_layout);
        resultNoDialog.setTitle("You Do Not Need An Antibiotic!");
        resultNoDialog.show();

        Button doneButton;

        doneButton = (Button) resultNoDialog.findViewById(R.id.doneButton);
        assert doneButton != null;
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Done Button from Result No Dialog was Clicked!");

                resultNoDialog.dismiss();
                displayAntibioticFactDialog();
            }
        });


    }

    private void displayAntibioticFactDialog() {
        final Dialog antibioticFactDialog = new Dialog(this);
        antibioticFactDialog.setContentView(R.layout.dialog_antibiotic_fact_layout);
        antibioticFactDialog.show();

        Toast.makeText(this, "Please scroll down to see all facts.", Toast.LENGTH_LONG).show();

        // Create a string array and populate it with the string array from the "string.xml" file
        String[] factArray = getResources().getStringArray(R.array.fact_array);

        // Create an ArrayList to add the "factArray" to, this is to add the index number to the output.
        ArrayList<String> factArrayList = new ArrayList<String>();

        // Populate the "factArrayList" with facts from the "factArray"
        for (int i = 0; i < factArray.length; i++) {
            factArrayList.add( (i + 1) + ". " + factArray[i]);
        }

        //Initialize ArrayAdapter to pass to ListView
                                        /*Context,             layout,             array or arrayList*/
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_list_view, factArrayList);

        // Create ListView object and link to reference in activity_main.xml
        // Only need to link the ListView in onCreate
        ListView factListView = (ListView) antibioticFactDialog.findViewById(R.id.factListView);
        factListView.setAdapter(adapter); // Assign the ArrayAdapter to the ListView object

        Button doneButton;
        doneButton = (Button) antibioticFactDialog.findViewById(R.id.doneButton);
        assert doneButton != null;
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Done Button from Result No Dialog was Clicked!");
                // User confirms so reset app
                startActivity(new Intent(QuestionnaireOneActivity.this, TitleScreenActivity.class));
                antibioticFactDialog.dismiss();
            }
        });
    }

    private void resultYesDialog() {
        final Dialog resultYesAntibioticDialog = new Dialog(this);
        resultYesAntibioticDialog.setContentView(R.layout.dialog_result_yes_layout);
        resultYesAntibioticDialog.setTitle("You Do Need An Antibiotic!");
        resultYesAntibioticDialog.show();

        Button doneButton;

        /*
        cancelButton
        cancelButton = (Button) resultYesAntibioticDialog.findViewById(R.id.cancelButton);
        assert cancelButton != null;
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Cancel Button from the result yes dialog was selected!");

                // User cancels so reset all check boxes
                for (CheckBox selected : selectedCheckBox) {
                    selected.setEnabled(true);
                    selected.setChecked(false);
                }

                for (CheckBox notSelected : notSelectedCheckBox) {
                    notSelected.setEnabled(true);
                    notSelected.setChecked(false);
                }

                // The selected checkbox list and not selected checkbox list need to be cleared
                selectedCheckBox = new ArrayList<CheckBox>();
                notSelectedCheckBox = new ArrayList<CheckBox>();
                resultYesAntibioticDialog.cancel();
            }
        });
*/
        doneButton = (Button) resultYesAntibioticDialog.findViewById(R.id.doneButton);
        assert doneButton != null;
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Done Button from Result Yes Dialog was Clicked!");

                resultYesAntibioticDialog.dismiss();
                displayAntibioticFactDialog();
            }
        });


    }

    /*
            This method creates an alert dialog for when the "yes" checkbox for fever is selected.
     */
    private void feverDialog() {
        final Dialog feverDialog = new Dialog(this);
        feverDialog.setContentView(R.layout.dialog_fever_layout);
      //  feverDialog.setTitle(R.string.fever_dialog_title_text);
        feverDialog.show();

        lowFeverRange = (CheckBox) feverDialog.findViewById(R.id.lowFeverRangeCheckBox);
        assert lowFeverRange != null;
        lowFeverRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Low Fever Range was selected.");

                disable(lowFeverRange, highFeverRange);
                selectedCheckBox.add(lowFeverRange);
                notSelectedCheckBox.add(highFeverRange);

                selectedCheckBoxStack.push(lowFeverRange);
                notSelectedCheckBoxStack.push(highFeverRange);

            }
        });

        highFeverRange = (CheckBox) feverDialog.findViewById(R.id.highFeverRangeCheckBox);
        assert highFeverRange != null;
        highFeverRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "High Fever Range was selected.");

                disable(lowFeverRange, highFeverRange);
                selectedCheckBox.add(highFeverRange);
                notSelectedCheckBox.add(lowFeverRange);

                selectedCheckBoxStack.push(highFeverRange);
                notSelectedCheckBoxStack.push(lowFeverRange);

            }
        });

        Button cancelButton, confirmButton;

        cancelButton = (Button) feverDialog.findViewById(R.id.cancelButton);
        assert cancelButton != null;
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                        Check the selectedCheckBox list for "feverYes" and either of the available choices.
                        Check to make sure "feverYes" is not the only item selected.
                        Remove the added CheckBoxes from both the "selected" and
                            "notSelected" lists if "feverYes" and/or a fever range are selected.
                 */
                if (selectedCheckBox.contains(feverYes) && (selectedCheckBox.contains(lowFeverRange) || selectedCheckBox.contains(highFeverRange))) {

                    for (int i = 1, n = selectedCheckBox.size(); i < 3 ; i++) {
                        selectedCheckBox.remove(n - i);
                        notSelectedCheckBox.remove(n - i);
                    }


                } else if (selectedCheckBox.contains(feverYes)) {

                    for (int i = 1, n = selectedCheckBox.size(); i < 2 ; i++) {
                        selectedCheckBox.remove(n - i);
                        notSelectedCheckBox.remove(n - i);
                    }
                }

                  /*
                        Check the selectedCheckBoxStack list for "feverYes" and either of the available choices
                 */
                if (selectedCheckBoxStack.contains(feverYes) && (selectedCheckBoxStack.contains(lowFeverRange) || selectedCheckBoxStack.contains(highFeverRange))) {

                    for (int i = 1, n = selectedCheckBoxStack.size(); i < 3 ; i++) {
                        selectedCheckBoxStack.remove(n - i);
                        notSelectedCheckBoxStack.remove(n - i);
                    }

                } else if (selectedCheckBoxStack.contains(feverYes)) {

                    for (int i = 1, n = selectedCheckBoxStack.size(); i < 2 ; i++) {
                        selectedCheckBoxStack.remove(n - i);
                        notSelectedCheckBoxStack.remove(n - i);
                    }


                }

                // Debug Stuff --> --> --> -->
                Log.v(TAG, "Cancel Button from Fever Dialog was Clicked!");
                Log.v(TAG, "This is the selected checkbox list:");
                printSelectionList(selectedCheckBox);
                Log.v(TAG, "This is the not selected checkbox list:");
                printSelectionList(notSelectedCheckBox);


                resetCheckBoxOnCancel(feverYes, feverNo);
                feverDialog.cancel();
            }
        });

        confirmButton = (Button) feverDialog.findViewById(R.id.confirmButton);
        assert confirmButton != null;
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                feverDialog.dismiss();
                Log.v(TAG, "Confirm Button from Fever Dialog was Clicked!");
            }
        });

    } // Closes the fever dialog method

    /*
            This method creates an alert dialog to prompt the user to choose what color their
            nasal discharge is.
    */
    private void nasalDischargeColorDialog() {
        final Dialog nasalDischargeDialog = new Dialog(this);
        nasalDischargeDialog.setContentView(R.layout.dialog_nasal_discharge_layout);
        nasalDischargeDialog.show();

        // Set up Listeners for the nasal discharge color
        colorClear = (CheckBox) nasalDischargeDialog.findViewById(R.id.nasalDischargeColorClearCheckbox);
        assert colorClear != null;
        colorClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Nasal Discharge Clear was selected!!!");
                disable(colorClear, colorYellowGreen);

                selectedCheckBox.add(colorClear);

                notSelectedCheckBox.add(colorYellowGreen);

                selectedCheckBoxStack.push(colorClear);

                notSelectedCheckBoxStack.push(colorYellowGreen);

            }
        });

        colorYellowGreen = (CheckBox) nasalDischargeDialog.findViewById(R.id.nasalDischargeColorYellowGreenCheckbox);
        assert colorYellowGreen != null;
        colorYellowGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Nasal Discharge Yellow Green was selected!!!");
                disable(colorClear, colorYellowGreen);

                selectedCheckBox.add(colorYellowGreen);

                notSelectedCheckBox.add(colorClear);

                selectedCheckBoxStack.push(colorYellowGreen);

                notSelectedCheckBoxStack.push(colorClear);

            }
        });

        Button cancelButton, confirmButton;

        cancelButton = (Button) nasalDischargeDialog.findViewById(R.id.cancelButton);
        assert cancelButton != null;
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Cancel Button from the Nasal Discharge Dialog was Clicked!");


                if (selectedCheckBox.contains(nasalDischargeYes)) {
                    // Remove "nasalDischargeYes", one item total
                    // Remove "nasalDischargeNo", one item total
                    for (int i = 1, n = selectedCheckBox.size(); i < 2 ; i++) {
                        selectedCheckBox.remove(n - i);

                        notSelectedCheckBox.remove(n - i);
                    }


                } else if (selectedCheckBox.contains(nasalDischargeYes) && (selectedCheckBox.contains(colorClear) || selectedCheckBox.contains(colorYellowGreen))) {
                    // Remove "nasalDischargeYes" and nasal discharge choice, two items total
                    // Remove "nasalDischargeNo" and nasal discharge choice not selected, two items total
                    for (int i = 1, n = selectedCheckBox.size(); i < 3 ; i++) {
                        selectedCheckBox.remove(n - i);

                        notSelectedCheckBox.remove(n - i);
                    }
                }



                if (selectedCheckBoxStack.contains(nasalDischargeYes)) {

                    for (int i = 1, n = selectedCheckBoxStack.size(); i < 2 ; i++) {
                        selectedCheckBoxStack.remove(n - i);
                    }

                    for (int i = 1, n = notSelectedCheckBoxStack.size(); i < 2 ; i++) {
                        notSelectedCheckBoxStack.remove(n - i);
                    }

                } else if (selectedCheckBoxStack.contains(nasalDischargeYes) && (selectedCheckBoxStack.contains(colorClear) || selectedCheckBoxStack.contains(colorYellowGreen))) {
                    // Remove "nasalDischargeYes" and nasal discharge color choice, two items total
                    for (int i = 1, n = selectedCheckBoxStack.size(); i < 3 ; i++) {
                        selectedCheckBoxStack.remove(n - i);
                    }
                    // Remove "nasalDischargeNo" and nasal discharge color choice not selected, ten items total
                    for (int i = 1, n = notSelectedCheckBoxStack.size(); i < 3 ; i++) {
                        notSelectedCheckBoxStack.remove(n - i);
                    }
                }


                /*
                // Check for items added to selectedCheckBox list and remove them
                if (selectedCheckBox.contains(nasalDischargeYes) && (selectedCheckBox.contains(colorClear) || selectedCheckBox.contains(colorYellowGreen))) {

                    // Remove "nasalDischargeYes" and nasal discharge choice, two items total
                    for (int i = 1, n = selectedCheckBox.size(); i < 3 ; i++) {
                        selectedCheckBox.remove(n - i);
                    }
                    // Remove "preExistingNo" and pre existing choices not selected, ten items total
                    for (int i = 1, n = notSelectedCheckBox.size(); i < 3 ; i++) {
                        notSelectedCheckBox.remove(n - i);
                    }
                }

                if (selectedCheckBoxStack.contains(nasalDischargeYes) && (selectedCheckBoxStack.contains(colorClear) || selectedCheckBoxStack.contains(colorYellowGreen))) {

                    // Remove "nasalDischargeYes" and nasal discharge color choice, two items total
                    for (int i = 1, n = selectedCheckBoxStack.size(); i < 3 ; i++) {
                        selectedCheckBoxStack.remove(n - i);
                    }
                    // Remove "nasalDischargeNo" and nasal discharge color choice not selected, ten items total
                    for (int i = 1, n = notSelectedCheckBoxStack.size(); i < 3 ; i++) {
                        notSelectedCheckBoxStack.remove(n - i);
                    }

                }
                */

                // Debug Stuff --> --> --> -->
                Log.v(TAG, "Cancel Button from Nasal Discharge Dialog was Clicked!");
                Log.v(TAG, "This is the selected checkbox list:");
                printSelectionList(selectedCheckBox);
                Log.v(TAG, "This is the not selected checkbox list:");
                printSelectionList(notSelectedCheckBox);

                resetCheckBoxOnCancel(nasalDischargeYes, nasalDischargeNo);
                nasalDischargeDialog.cancel();
            }
        });

        confirmButton = (Button) nasalDischargeDialog.findViewById(R.id.confirmButton);
        assert confirmButton != null;
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nasalDischargeDialog.dismiss();
                Log.v(TAG, "Confirm Button from Dialog was Clicked!");
            }
        });
    } // Closes nasal discharge dialog method

    /*
            This method creates an alert dialog to prompt the user to select
            which pre-existing condition applies to them.
     */
    private void preExistingConditionDialog() {

        final Dialog preExistingConditionDialog = new Dialog(this);
        preExistingConditionDialog.setContentView(R.layout.dialog_pre_existing_conditions_layout);
        preExistingConditionDialog.show();


        ////////////// CheckBox Instantiation Pre Existing Conditions Dialog //////////////////
        /*
            Add Listeners for all the check boxes in Pre Existing Dialog
            Add selections to their appropriate List

        */

        pregnantOrTwoWeeksPostpartum = (CheckBox) preExistingConditionDialog.findViewById(R.id.pregnantPostpartumCheckbox);
        assert pregnantOrTwoWeeksPostpartum != null;
        pregnantOrTwoWeeksPostpartum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Pregnant Postpartum was selected!!!");
                disable(pregnantOrTwoWeeksPostpartum, cancer, copd, cad, hiv, aids, recentUseOfAntibiotic, recentHospitalization, autoimmuneDisease, chronicSteroidUse);

                selectedCheckBox.add(pregnantOrTwoWeeksPostpartum);

                notSelectedCheckBox.add(cancer);
                notSelectedCheckBox.add(copd);
                notSelectedCheckBox.add(cad);
                notSelectedCheckBox.add(hiv);
                notSelectedCheckBox.add(aids);
                notSelectedCheckBox.add(recentUseOfAntibiotic);
                notSelectedCheckBox.add(recentHospitalization);
                notSelectedCheckBox.add(autoimmuneDisease);
                notSelectedCheckBox.add(chronicSteroidUse);

            }
        });

        cancer = (CheckBox) preExistingConditionDialog.findViewById(R.id.cancerCheckbox);
        assert cancer != null;
        cancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Cancer was selected!!!");
                disable(pregnantOrTwoWeeksPostpartum, cancer, copd, cad, hiv, aids, recentUseOfAntibiotic, recentHospitalization, autoimmuneDisease, chronicSteroidUse);

                selectedCheckBox.add(cancer);

                notSelectedCheckBox.add(pregnantOrTwoWeeksPostpartum);
                notSelectedCheckBox.add(copd);
                notSelectedCheckBox.add(cad);
                notSelectedCheckBox.add(hiv);
                notSelectedCheckBox.add(aids);
                notSelectedCheckBox.add(recentUseOfAntibiotic);
                notSelectedCheckBox.add(recentHospitalization);
                notSelectedCheckBox.add(autoimmuneDisease);
                notSelectedCheckBox.add(chronicSteroidUse);

            }
        });

        copd = (CheckBox) preExistingConditionDialog.findViewById(R.id.copdCheckbox);
        assert copd != null;
        copd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "COPD was selected!!!");
                disable(pregnantOrTwoWeeksPostpartum, cancer, copd, cad, hiv, aids, recentUseOfAntibiotic, recentHospitalization, autoimmuneDisease, chronicSteroidUse);

                selectedCheckBox.add(copd);

                notSelectedCheckBox.add(pregnantOrTwoWeeksPostpartum);
                notSelectedCheckBox.add(cancer);
                notSelectedCheckBox.add(cad);
                notSelectedCheckBox.add(hiv);
                notSelectedCheckBox.add(aids);
                notSelectedCheckBox.add(recentUseOfAntibiotic);
                notSelectedCheckBox.add(recentHospitalization);
                notSelectedCheckBox.add(autoimmuneDisease);
                notSelectedCheckBox.add(chronicSteroidUse);

            }
        });

        cad = (CheckBox) preExistingConditionDialog.findViewById(R.id.cadCheckbox);
        assert cad != null;
        cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "CAD was selected!!!");
                disable(pregnantOrTwoWeeksPostpartum, cancer, copd, cad, hiv, aids, recentUseOfAntibiotic, recentHospitalization, autoimmuneDisease, chronicSteroidUse);

                selectedCheckBox.add(cad);

                notSelectedCheckBox.add(pregnantOrTwoWeeksPostpartum);
                notSelectedCheckBox.add(cancer);
                notSelectedCheckBox.add(copd);
                notSelectedCheckBox.add(hiv);
                notSelectedCheckBox.add(aids);
                notSelectedCheckBox.add(recentUseOfAntibiotic);
                notSelectedCheckBox.add(recentHospitalization);
                notSelectedCheckBox.add(autoimmuneDisease);
                notSelectedCheckBox.add(chronicSteroidUse);

            }
        });

        hiv = (CheckBox) preExistingConditionDialog.findViewById(R.id.hivCheckbox);
        assert hiv != null;
        hiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "HIV was selected!!!");
                disable(pregnantOrTwoWeeksPostpartum, cancer, copd, cad, hiv, aids, recentUseOfAntibiotic, recentHospitalization, autoimmuneDisease, chronicSteroidUse);

                selectedCheckBox.add(hiv);

                notSelectedCheckBox.add(pregnantOrTwoWeeksPostpartum);
                notSelectedCheckBox.add(cancer);
                notSelectedCheckBox.add(copd);
                notSelectedCheckBox.add(cad);
                notSelectedCheckBox.add(aids);
                notSelectedCheckBox.add(recentUseOfAntibiotic);
                notSelectedCheckBox.add(recentHospitalization);
                notSelectedCheckBox.add(autoimmuneDisease);
                notSelectedCheckBox.add(chronicSteroidUse);

            }
        });

        aids = (CheckBox) preExistingConditionDialog.findViewById(R.id.aidsCheckbox);
        assert aids != null;
        aids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "AIDS was selected!!!");
                disable(pregnantOrTwoWeeksPostpartum, cancer, copd, cad, hiv, aids, recentUseOfAntibiotic, recentHospitalization, autoimmuneDisease, chronicSteroidUse);

                selectedCheckBox.add(aids);

                notSelectedCheckBox.add(pregnantOrTwoWeeksPostpartum);
                notSelectedCheckBox.add(cancer);
                notSelectedCheckBox.add(copd);
                notSelectedCheckBox.add(cad);
                notSelectedCheckBox.add(hiv);
                notSelectedCheckBox.add(recentUseOfAntibiotic);
                notSelectedCheckBox.add(recentHospitalization);
                notSelectedCheckBox.add(autoimmuneDisease);
                notSelectedCheckBox.add(chronicSteroidUse);

            }
        });

        recentUseOfAntibiotic = (CheckBox) preExistingConditionDialog.findViewById(R.id.recentUseOfAntibioticCheckbox);
        assert recentUseOfAntibiotic != null;
        recentUseOfAntibiotic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Recent Use of Antibiotic was selected!!!");
                disable(pregnantOrTwoWeeksPostpartum, cancer, copd, cad, hiv, aids, recentUseOfAntibiotic, recentHospitalization, autoimmuneDisease, chronicSteroidUse);

                selectedCheckBox.add(recentUseOfAntibiotic);

                notSelectedCheckBox.add(pregnantOrTwoWeeksPostpartum);
                notSelectedCheckBox.add(cancer);
                notSelectedCheckBox.add(copd);
                notSelectedCheckBox.add(cad);
                notSelectedCheckBox.add(hiv);
                notSelectedCheckBox.add(aids);
                notSelectedCheckBox.add(recentHospitalization);
                notSelectedCheckBox.add(autoimmuneDisease);
                notSelectedCheckBox.add(chronicSteroidUse);

            }
        });

        recentHospitalization = (CheckBox) preExistingConditionDialog.findViewById(R.id.recentHospitalizationCheckbox);
        assert recentHospitalization != null;
        recentHospitalization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Recent Hospitalization was selected!!!");
                disable(pregnantOrTwoWeeksPostpartum, cancer, copd, cad, hiv, aids, recentUseOfAntibiotic, recentHospitalization, autoimmuneDisease, chronicSteroidUse);

                selectedCheckBox.add(recentHospitalization);

                notSelectedCheckBox.add(pregnantOrTwoWeeksPostpartum);
                notSelectedCheckBox.add(cancer);
                notSelectedCheckBox.add(copd);
                notSelectedCheckBox.add(cad);
                notSelectedCheckBox.add(hiv);
                notSelectedCheckBox.add(aids);
                notSelectedCheckBox.add(recentUseOfAntibiotic);
                notSelectedCheckBox.add(autoimmuneDisease);
                notSelectedCheckBox.add(chronicSteroidUse);

            }
        });

        autoimmuneDisease = (CheckBox) preExistingConditionDialog.findViewById(R.id.autoimmuneDiseaseCheckbox);
        assert autoimmuneDisease != null;
        autoimmuneDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Autoimmune Disease was selected!!!");
                disable(pregnantOrTwoWeeksPostpartum, cancer, copd, cad, hiv, aids, recentUseOfAntibiotic, recentHospitalization, autoimmuneDisease, chronicSteroidUse);

                selectedCheckBox.add(autoimmuneDisease);

                notSelectedCheckBox.add(pregnantOrTwoWeeksPostpartum);
                notSelectedCheckBox.add(cancer);
                notSelectedCheckBox.add(copd);
                notSelectedCheckBox.add(cad);
                notSelectedCheckBox.add(hiv);
                notSelectedCheckBox.add(aids);
                notSelectedCheckBox.add(recentUseOfAntibiotic);
                notSelectedCheckBox.add(recentHospitalization);
                notSelectedCheckBox.add(chronicSteroidUse);

            }
        });

        chronicSteroidUse = (CheckBox) preExistingConditionDialog.findViewById(R.id.chronicSteroidUseCheckbox);
        assert chronicSteroidUse != null;
        chronicSteroidUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Chronic Steroid Use was selected!!!");
                disable(pregnantOrTwoWeeksPostpartum, cancer, copd, cad, hiv, aids, recentUseOfAntibiotic, recentHospitalization, autoimmuneDisease, chronicSteroidUse);

                selectedCheckBox.add(chronicSteroidUse);

                notSelectedCheckBox.add(pregnantOrTwoWeeksPostpartum);
                notSelectedCheckBox.add(cancer);
                notSelectedCheckBox.add(copd);
                notSelectedCheckBox.add(cad);
                notSelectedCheckBox.add(hiv);
                notSelectedCheckBox.add(aids);
                notSelectedCheckBox.add(recentUseOfAntibiotic);
                notSelectedCheckBox.add(recentHospitalization);
                notSelectedCheckBox.add(autoimmuneDisease);

            }
        });


        Button cancelButton, confirmButton;

        cancelButton = (Button) preExistingConditionDialog.findViewById(R.id.cancelButton);
        assert cancelButton != null;
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Check for items added to selectedCheckBox list and remove them
               if (selectedCheckBox.contains(preExistingConditionsYes) && (selectedCheckBox.contains(pregnantOrTwoWeeksPostpartum) || selectedCheckBox.contains(cancer)
                       || selectedCheckBox.contains(copd) || selectedCheckBox.contains(cad) || selectedCheckBox.contains(hiv) || selectedCheckBox.contains(aids)
                       || selectedCheckBox.contains(recentUseOfAntibiotic) || selectedCheckBox.contains(recentHospitalization) || selectedCheckBox.contains(autoimmuneDisease)
                       || selectedCheckBox.contains(chronicSteroidUse))) {

                   // Remove "preExistingYes" and pre existing choice, two items total
                   for (int i = 1, n = selectedCheckBox.size(); i < 3 ; i++) {
                       selectedCheckBox.remove(n - i);
                   }
                   // Remove "preExistingNo" and pre existing choices not selected, ten items total
                   for (int i = 1, n = notSelectedCheckBox.size(); i < 11 ; i++) {
                       notSelectedCheckBox.remove(n - i);
                   }
               } else if (selectedCheckBox.contains(preExistingConditionsYes)) {
                   for (int i = 1, n = selectedCheckBox.size(); i < 2 ; i++) {
                       selectedCheckBox.remove(n - i);
                       notSelectedCheckBox.remove(n - i);

                   }
               }

                // Check for items added to selectedCheckBoxStack and remove them
                if (selectedCheckBoxStack.contains(preExistingConditionsYes) && (selectedCheckBoxStack.contains(pregnantOrTwoWeeksPostpartum) || selectedCheckBoxStack.contains(cancer)
                        || selectedCheckBoxStack.contains(copd) || selectedCheckBoxStack.contains(cad) || selectedCheckBoxStack.contains(hiv) || selectedCheckBoxStack.contains(aids)
                        || selectedCheckBoxStack.contains(recentUseOfAntibiotic) || selectedCheckBoxStack.contains(recentHospitalization) || selectedCheckBoxStack.contains(autoimmuneDisease)
                        || selectedCheckBoxStack.contains(chronicSteroidUse))) {

                    // Remove "preExistingYes" and pre existing choice, two items total
                    for (int i = 1, n = selectedCheckBoxStack.size(); i < 3 ; i++) {
                        selectedCheckBoxStack.remove(n - i);
                    }
                    // Remove "preExistingNo" and pre existing choices not selected, ten items total
                    for (int i = 1, n = notSelectedCheckBoxStack.size(); i < 11 ; i++) {
                        notSelectedCheckBoxStack.remove(n - i);
                    }
                } else if (selectedCheckBoxStack.contains(preExistingConditionsYes)) {
                    for (int i = 1, n = selectedCheckBoxStack.size(); i < 2; i++) {
                        selectedCheckBoxStack.remove(n - i);
                        notSelectedCheckBoxStack.remove(n - i);

                    }
                }

                // Debug Stuff --> --> --> -->
                Log.v(TAG, "Cancel Button from Pre Existing Conditions Dialog was Clicked!");
                Log.v(TAG, "This is the selected checkbox list:");
                printSelectionList(selectedCheckBox);
                Log.v(TAG, "This is the not selected checkbox list:");
                printSelectionList(notSelectedCheckBox);

                resetCheckBoxOnCancel(preExistingConditionsYes, preExistingConditionsNo);
                preExistingConditionDialog.cancel();
            }

        });

        confirmButton = (Button) preExistingConditionDialog.findViewById(R.id.confirmButton);
        assert confirmButton != null;
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preExistingConditionDialog.dismiss();
                Log.v(TAG, "Confirm Button from pre existing Dialog was Clicked!");
            }
        });
    } // Closes pre-existing dialog method

    /*
           This method resets the "yes" and "no" checkboxes if the cancel button
           is selected on a dialog.
     */
    private void resetCheckBoxOnCancel(CheckBox yes, CheckBox no) {
        yes.setEnabled(true);
        no.setEnabled(true);
        yes.setChecked(false);
        no.setChecked(false);
    }

    /*
            This methods disables two checkboxes
     */
    private void disable(CheckBox yes, CheckBox no) {
        yes.setEnabled(false);
        no.setEnabled(false);
    }

    /*
           This methods disables three checkboxes
    */
    private void disable(CheckBox cb1, CheckBox cb2, CheckBox cb3) {
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }

    /*
            This methods disables ten checkboxes
    */
    private void disable(CheckBox cb1, CheckBox cb2, CheckBox cb3, CheckBox cb4, CheckBox cb5, CheckBox cb6, CheckBox cb7, CheckBox cb8, CheckBox cb9, CheckBox cb10) {

        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
        cb4.setEnabled(false);
        cb5.setEnabled(false);
        cb6.setEnabled(false);
        cb7.setEnabled(false);
        cb8.setEnabled(false);
        cb9.setEnabled(false);
        cb10.setEnabled(false);
    }


    // Debug Stuff --> --> --> --> --> --> --> --> --> -->
    /*
            This method prints a stack to the console
    */
    private void printSelectionStack(Stack<CheckBox> inputStack) {

        for (CheckBox cb : inputStack) {
            Log.v(TAG, cb.toString());
        }

    }

    /*
            This method prints an array list to the console
    */
    private void printSelectionList(ArrayList<CheckBox> inputList) {

        for (CheckBox cb : inputList) {
          Log.v(TAG, cb.toString());
        }
    }

} // Closes the QuestionnaireOneActivity Class
