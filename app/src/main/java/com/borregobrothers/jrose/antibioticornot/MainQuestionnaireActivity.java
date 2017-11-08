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

/*
        Author: John Rose
        Date: October 2017
        Class is for the main activity of the antibiotic awareness app.
        It contains six dialogs implemented in methods and after the onCreate method.
        The onCreate methods contains all listener methods for the checkboxes selected.
 */
public class MainQuestionnaireActivity extends AppCompatActivity {

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
    private CheckBox pregnantOrTwoWeeksPostpartum, cancer, copd, hiv, aids, recentUseOfAntibiotic, recentHospitalization, chronicSteroidUse;

    // Make an ArrayList to hold all the values of the selected checkboxes
    private ArrayList<CheckBox> selectedCheckBoxList = new ArrayList<>();

    // Make an ArrayList to hold all the values of the checkboxes not selected
    private ArrayList<CheckBox> notSelectedCheckBoxList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_questionnaire_layout);

        /*
                The listener method displays the fever alert dialog if the "yes" checkbox for
                fever is selected. The method also disables both the "yes" and "no" checkboxes
                and adds "yes" to the selectedCheckBoxList list.
         */
        feverYes = (CheckBox) findViewById(R.id.feverYes);
        assert feverYes != null;
        feverYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                addCheckBox(feverYes, feverNo, selectedCheckBoxList, notSelectedCheckBoxList);
                ;
                createFeverDialog();

            }
        });

        /*
                The listener method disables both the "yes" and  "no" checkboxes if
                the fever "no" checkbox is selected  and adds "no" to the selectedCheckBoxList list.
         */
        feverNo = (CheckBox) findViewById(R.id.feverNo);
        assert feverNo != null;
        feverNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(feverNo, feverYes, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });


        /*
                The listener method disables the "yes" and "no" checkboxes if the cough "yes"
                checkbox is selected and adds "yes" to the selectedCheckBoxList list.
         */
        coughYes = (CheckBox) findViewById(R.id.coughYes);
        assert coughYes != null;
        coughYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(coughYes, coughNo, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the cough "no" checkbox is selected and adds "no" to the selectedCheckBoxList list.
         */
        coughNo = (CheckBox) findViewById(R.id.coughNo);
        assert coughNo != null;
        coughNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(coughNo, coughYes, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });


        /*
                The listener method disables the "yes" and "no" checkboxes if the sore throat
                 hoarseness "yes" checkbox is selected and adds "yes" to the selectedCheckBoxList list.
         */
        soreThroatHoarsenessYes = (CheckBox) findViewById(R.id.soreThroatHoarsenessYes);
        assert soreThroatHoarsenessYes != null;
        soreThroatHoarsenessYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(soreThroatHoarsenessYes, soreThroatHoarsenessNo, selectedCheckBoxList, notSelectedCheckBoxList);


            }
        });

        /*
                The listener method disable both the "yes" and the "no" checkbox if
                the sore throat hoarseness "no" checkbox is selected and adds "no"
                to the selectedCheckBoxList list.
         */
        soreThroatHoarsenessNo = (CheckBox) findViewById(R.id.soreThroatHoarsenessNo);
        assert soreThroatHoarsenessNo != null;
        soreThroatHoarsenessNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(soreThroatHoarsenessNo, soreThroatHoarsenessYes, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

        /*
                The listener method disables the "yes" and "no" checkboxes if the white patches
                "yes" checkbox is selected and adds "yes" to the selectedCheckBoxList list.
         */
        whitePatchesYes = (CheckBox) findViewById(R.id.whitePatchesInThroatYes);
        assert whitePatchesYes != null;
        whitePatchesYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(whitePatchesYes, whitePatchesNo, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the white patches "no" checkbox is selected and adds "no" to the selectedCheckBoxList list.
         */
        whitePatchesNo = (CheckBox) findViewById(R.id.whitePatchesInThroatNo);
        assert whitePatchesNo != null;
        whitePatchesNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(whitePatchesNo, whitePatchesYes, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });


        /*
                The listener method disables the "yes" and "no" checkboxes if the facial pain "yes"
                checkbox is selected and adds "yes" to the selectedCheckBoxList list.
         */
        facialPainYes = (CheckBox) findViewById(R.id.facialPainYes);
        assert facialPainYes != null;
        facialPainYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(facialPainYes, facialPainNo, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

        /*
                The listener method disable both the "yes" and the "no" checkbox if
                the facial pain "no" checkbox is selected and adds "no" to the selectedCheckBoxList list.
         */
        facialPainNo = (CheckBox) findViewById(R.id.facialPainNo);
        assert facialPainNo!= null;
        facialPainNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(facialPainNo, facialPainYes, selectedCheckBoxList, notSelectedCheckBoxList);
            }
        });

        /*
                The listener method disables the "yes" and "no" checkboxes if the body
                ache "yes" checkbox is selected and adds "yes" to the selectedCheckBoxList list.
         */
        bodyAcheYes = (CheckBox) findViewById(R.id.bodyAcheYes);
        assert bodyAcheYes != null;
        bodyAcheYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(bodyAcheYes, bodyAcheNo, selectedCheckBoxList, notSelectedCheckBoxList);
            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the body ache "no" checkbox is selected and adds "no" to the selectedCheckBoxList list.
         */
        bodyAcheNo = (CheckBox) findViewById(R.id.bodyAcheNo);
        assert bodyAcheNo != null;
        bodyAcheNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(bodyAcheNo, bodyAcheYes, selectedCheckBoxList, notSelectedCheckBoxList);
            }
        });

        /*
                The listener method disables the "yes" and "no" checkboxes if the sneezing "yes"
                checkbox is selected and adds "yes" to the selectedCheckBoxList list.
         */
        sneezingYes = (CheckBox) findViewById(R.id.sneezingYes);
        assert sneezingYes != null;
        sneezingYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(sneezingYes, sneezingNo, selectedCheckBoxList, notSelectedCheckBoxList);
            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the sneezing "no" checkbox is selected and adds "no" to the selectedCheckBoxList list.
         */
        sneezingNo = (CheckBox) findViewById(R.id.sneezingNo);
        assert sneezingNo != null;
        sneezingNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(sneezingNo, sneezingYes, selectedCheckBoxList, notSelectedCheckBoxList);
            }
        });

          /*
            The listener method disables both the "yes" and the "no" checkbox if
            nasal congestion "yes" checkbox is selected and adds "yes" to the selectedCheckBoxList list.
         */
        nasalCongestionYes = (CheckBox) findViewById(R.id.nasalCongestionYes);

        assert nasalCongestionYes != null;
        nasalCongestionYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Nasal Congestion Yes Checkbox was Selected!");

                addCheckBox(nasalCongestionYes, nasalCongestionNo, selectedCheckBoxList, notSelectedCheckBoxList);
            }
        });

        /*
            The listener method disables both the "yes" and the "no" checkbox if
            nasal congestion "no" checkbox is selected and adds "no" to the selectedCheckBoxList list.
         */
        nasalCongestionNo = (CheckBox) findViewById(R.id.nasalCongestionNo);
        assert nasalCongestionNo != null;
        nasalCongestionNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(nasalCongestionNo, nasalCongestionYes, selectedCheckBoxList, notSelectedCheckBoxList);
            }
        });

        /*
                The listener method displays an alert dialog if the "yes" checkbox for
                nasal discharge is selected.  The method also disables both the "yes" and "no" checkboxes
                and adds "yes" to the selectedCheckBoxList list.
         */
        nasalDischargeYes = (CheckBox) findViewById(R.id.nasalDischargeYes);

        assert nasalDischargeYes != null;
        nasalDischargeYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Nasal Discharge Yes Checkbox was Selected!");
                createNasalDischargeColorDialog();

                addCheckBox(nasalDischargeYes, nasalDischargeNo, selectedCheckBoxList, notSelectedCheckBoxList);
            }
        });

        /*
            The listener method disables both the "yes" and the "no" checkbox if
            nasal discharge "no" checkbox is selected and adds "no" to the selectedCheckBoxList list.
         */
        nasalDischargeNo = (CheckBox) findViewById(R.id.nasalDischargeNo);
        assert nasalDischargeNo != null;
        nasalDischargeNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(nasalDischargeNo, nasalDischargeYes, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

         /*
                The listener method disables the "yes" and "no" checkboxes if the post
                nasal drip "yes" checkbox is selected and adds "yes" to the selectedCheckBoxList list.
         */
        postNasalDripYes = (CheckBox) findViewById(R.id.postNasalDripYes);
        assert postNasalDripYes != null;
        postNasalDripYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(postNasalDripYes, postNasalDripNo, selectedCheckBoxList, notSelectedCheckBoxList);
            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the post nasal drip "no" checkbox is selected and adds "no" to the selectedCheckBoxList list.
         */
        postNasalDripNo = (CheckBox) findViewById(R.id.postNasalDripNo);
        assert postNasalDripNo != null;
        postNasalDripNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(postNasalDripNo, postNasalDripYes, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

         /*
                The listener method disables the "yes" and "no" checkboxes if the shortness
                 of breath or wheezing "yes" checkbox is selected and adds "yes" to the selectedCheckBoxList list.
         */
        shortnessOfBreathWheezingYes = (CheckBox) findViewById(R.id.shortnessOfBreathWheezingYes);
        assert shortnessOfBreathWheezingYes != null;
        shortnessOfBreathWheezingYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(shortnessOfBreathWheezingYes, shortnessOfBreathWheezingNo, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the shortness of breath or wheezing "no" checkbox is selected and adds
                "no" to the selectedCheckBoxList list.
         */
        shortnessOfBreathWheezingNo = (CheckBox) findViewById(R.id.shortnessOfBreathWheezingNo);
        assert shortnessOfBreathWheezingNo != null;
        shortnessOfBreathWheezingNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(shortnessOfBreathWheezingNo, shortnessOfBreathWheezingYes, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });


        /*
                The listener method disables the "yes" and "no" checkboxes if the chest pains "yes"
                checkbox is selected and adds "yes" to the selectedCheckBoxList list.
         */
        chestPainYes = (CheckBox) findViewById(R.id.chestPainYes);
        assert chestPainYes != null;
        chestPainYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(chestPainYes, chestPainNo, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the chest pain "no" checkbox is selected and adds "no" to the selectedCheckBoxList list.
         */
        chestPainNo = (CheckBox) findViewById(R.id.chestPainNo);
        assert chestPainNo != null;
        chestPainNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(chestPainNo, chestPainYes, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

        /*
                The listener method disables the "yes" and "no" checkboxes if the neck
                stiffness "yes" checkbox is selected and adds "yes" to the selectedCheckBoxList list.
         */
        neckStiffnessYes = (CheckBox) findViewById(R.id.neckStiffnessYes);
        assert neckStiffnessYes != null;
        neckStiffnessYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(neckStiffnessYes, neckStiffnessNo, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the neckStiffness "no" checkbox is selected and adds "no" to the selectedCheckBoxList list.
         */
        neckStiffnessNo = (CheckBox) findViewById(R.id.neckStiffnessNo);
        assert neckStiffnessNo != null;
        neckStiffnessNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(neckStiffnessNo, neckStiffnessYes, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

                /*
                The listener method disables the "yes" and "no" checkboxes if the neck
                stiffness "yes" checkbox is selected and adds "yes" to the selectedCheckBoxList list.
         */
        tenderLymphNodesYes = (CheckBox) findViewById(R.id.tenderLymphNodesYes);
        assert tenderLymphNodesYes != null;
        tenderLymphNodesYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(tenderLymphNodesYes, tenderLymphNodesNo, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the neckStiffness "no" checkbox is selected and adds "no" to the selectedCheckBoxList list.
         */
        tenderLymphNodesNo = (CheckBox) findViewById(R.id.tenderLymphNodesNo);
        assert tenderLymphNodesNo != null;
        tenderLymphNodesNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(tenderLymphNodesNo, tenderLymphNodesYes, selectedCheckBoxList, notSelectedCheckBoxList);


            }
        });

        /*
                The listener method disables the "yes" and "no" checkboxes if the fatigue "yes"
                checkbox is selected and adds "yes" to the selectedCheckBoxList list.
         */
        headacheYes = (CheckBox) findViewById(R.id.headacheYes);
        assert headacheYes != null;
        headacheYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(headacheYes, headacheNo, selectedCheckBoxList, notSelectedCheckBoxList);


            }
        });

        /*
                The listener method disables both the "yes" and the "no" checkboxes if
                the cough "no" checkbox is selected and adds "no" to the selectedCheckBoxList list.
         */
        headacheNo = (CheckBox) findViewById(R.id.headacheNo);
        assert headacheNo != null;
        headacheNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(headacheNo, headacheYes, selectedCheckBoxList, notSelectedCheckBoxList);

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
                createPreExistingConditionDialog();
                addCheckBox(preExistingConditionsYes, preExistingConditionsNo, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

        preExistingConditionsNo = (CheckBox) findViewById(R.id.preExistingConditionsNo);
        assert preExistingConditionsNo != null;
        preExistingConditionsNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCheckBox(preExistingConditionsNo, preExistingConditionsYes, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

        // Symptoms length of time
        symptomsLessThanSevenDays = (CheckBox) findViewById(R.id.lessThanSevenDays);
        assert symptomsLessThanSevenDays!= null;
        symptomsLessThanSevenDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Pre-existing Conditions Yes Checkbox was Selected!");
                addCheckBox(symptomsLessThanSevenDays, symptomsMoreThanSevenDays, selectedCheckBoxList, notSelectedCheckBoxList);
            }
        });

        // Symptoms length of time
        symptomsMoreThanSevenDays = (CheckBox) findViewById(R.id.moreThanSevenDays);
        assert symptomsMoreThanSevenDays!= null;
        symptomsMoreThanSevenDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Pre-existing Conditions Yes Checkbox was Selected!");
                addCheckBox(symptomsMoreThanSevenDays, symptomsLessThanSevenDays, selectedCheckBoxList, notSelectedCheckBoxList);

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

                // Prompt the user to  make sure the selections they made are the correct answers
                createSelectionConformationDialog();
                Log.v(TAG, "The result button was clicked!");
;
            }
        });

    } // Closes the onCreate method


    /*
            This method creates a dialog to prompt the user to confirm the selections made.
            The "yes" button will simply exit the dialog and the "no" button will reset will
            reset all checkboxes. The selectedCheckBoxList list will be emptied as well.
     */
    private Dialog createSelectionConformationDialog() {
        final Dialog selectionConformationDialog = new Dialog(this);
        selectionConformationDialog.setContentView(R.layout.dialog_selection_conformation_layout);
        selectionConformationDialog.setTitle(R.string.selection_dialog_title_text);
        selectionConformationDialog.show();

        final Button yesButton, noButton;

        yesButton = (Button) selectionConformationDialog.findViewById(R.id.yesButton);
        assert yesButton != null;
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Debug Stuff --> --> --> // Debug Stuff --> --> -->
                Log.v(TAG, "This is the selected checkbox list: --> --> --> -->");
                printSelectionList(selectedCheckBoxList);
                Log.v(TAG, "This is the not selected list: --> --> --> -->");
                printSelectionList(notSelectedCheckBoxList);

                /*
                        User is happy with selections made and confirms them
                        Display the correct result screen based on the options chosen by the user
                        Check for the checkboxes that determine antibiotic evaluation

                ArrayList<CheckBox> yesList = new ArrayList<CheckBox>();
                yesList.add(highFeverRange);
                yesList.add(whitePatchesYes);
                yesList.add(shortnessOfBreathWheezingYes);
                yesList.add(chestPainYes);
                yesList.add(neckStiffnessYes);
                yesList.add(tenderLymphNodesYes);
                yesList.add(preExistingConditionsYes);
                yesList.add(symptomsMoreThanSevenDays);
                */
                if (selectedCheckBoxList.contains(highFeverRange)
                        || selectedCheckBoxList.contains(whitePatchesYes)
                        || selectedCheckBoxList.contains(shortnessOfBreathWheezingYes)
                        || selectedCheckBoxList.contains(chestPainYes)
                        || selectedCheckBoxList.contains(neckStiffnessYes)
                        || selectedCheckBoxList.contains(tenderLymphNodesYes)
                        || selectedCheckBoxList.contains(preExistingConditionsYes)
                        || selectedCheckBoxList.contains(symptomsMoreThanSevenDays)) {
                    selectionConformationDialog.dismiss();
                    createResultYesDialog();
                } else {
                    selectionConformationDialog.dismiss();
                    createResultNoDialog();

                }
            } // Closes the yes onClick method
        });

        noButton = (Button) selectionConformationDialog.findViewById(R.id.noButton);
        assert noButton != null;
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // User is not happy with selections so all check boxes are reset
                for (CheckBox selected : selectedCheckBoxList) {
                    selected.setEnabled(true);
                    selected.setChecked(false);
                    selected.setClickable(true);
                }

                for (CheckBox notSelected : notSelectedCheckBoxList) {
                    notSelected.setEnabled(true);
                    notSelected.setChecked(false);
                    notSelected.setClickable(true);
                }

                // The selected checkbox list and not selected checkbox list need to be cleared
                selectedCheckBoxList = new ArrayList<CheckBox>();
                notSelectedCheckBoxList = new ArrayList<CheckBox>();

                selectionConformationDialog.dismiss();

            }
        });

        return selectionConformationDialog;
    } // Closes the selection conformation Dialog


    private Dialog createResultNoDialog() {
        final Dialog resultNoDialog = new Dialog(this);
        resultNoDialog.setContentView(R.layout.dialog_result_no_layout);
        resultNoDialog.show();

        Button doneButton, remedyButton;

        doneButton = (Button) resultNoDialog.findViewById(R.id.doneButton);
        assert doneButton != null;
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Done Button from Result No Dialog was Clicked!");

                resultNoDialog.dismiss();
                createAntibioticFactDialog();
            }
        });

        remedyButton = (Button) resultNoDialog.findViewById(R.id.remedyButton);
        assert remedyButton != null;
        remedyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resultNoDialog.dismiss();
                createOTCRemediesDialog();
            }
        });

        return resultNoDialog;
    }


    private Dialog createAntibioticFactDialog() {
        final Dialog antibioticFactDialog = new Dialog(this);
        antibioticFactDialog.setContentView(R.layout.dialog_antibiotic_fact_layout);
        antibioticFactDialog.show();

        Toast.makeText(this, "Please scroll down to see all facts.", Toast.LENGTH_SHORT).show();

        // Create a string array and populate it with the string array from the "string.xml" file
        String[] factArray = getResources().getStringArray(R.array.fact_array);

        // Create an ArrayList to add the "factArray" to, this is to add the index number to the output.
        ArrayList<String> factArrayList = new ArrayList<>();

        // Populate the "factArrayList" with facts from the "factArray" and add bullet point to list
        // "\u2022" = unicode for bullet point
        for (int i = 0; i < factArray.length; i++) {
            factArrayList.add("\u2022 " + factArray[i]);
        }


        //Initialize ArrayAdapter to pass to ListView
                                        /*Context,             layout,             array or arrayList*/
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.custom_list_view, factArrayList);

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
                startActivity(new Intent(MainQuestionnaireActivity.this, TitleScreenActivity.class));
                antibioticFactDialog.dismiss();
            }
        });

        return antibioticFactDialog;
    }


    private Dialog createResultYesDialog() {
        final Dialog resultYesAntibioticDialog = new Dialog(this);
        resultYesAntibioticDialog.setContentView(R.layout.dialog_result_yes_layout);
        resultYesAntibioticDialog.setTitle("You Do Need An Antibiotic!");
        resultYesAntibioticDialog.show();

        Button doneButton;
        doneButton = (Button) resultYesAntibioticDialog.findViewById(R.id.doneButton);
        assert doneButton != null;
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Done Button from Result Yes Dialog was Clicked!");

                resultYesAntibioticDialog.dismiss();
                createAntibioticFactDialog();
            }
        });

        return resultYesAntibioticDialog;
    }


    private Dialog createOTCRemediesDialog() {
        final Dialog remedyDialog = new Dialog(this);
        remedyDialog.setContentView(R.layout.dialog_remedy_layout);
        remedyDialog.show();

        // Toast.makeText(this, "Please scroll down to see all the OTC remedies.", Toast.LENGTH_SHORT).show();

        // Create a string array and populate it with the string array from the "string.xml" file
        String[] remedyArray = getResources().getStringArray(R.array.remedy_array);

        // Create an ArrayList to add the "factArray" to, this is to add the index number to the output.
        ArrayList<String> remedyArrayList = new ArrayList<>();

        // Populate the "factArrayList" with facts from the "factArray" and add bullet point to list
        // "\u2022" = unicode for bullet point

        for (String remedy : remedyArray) {
            remedyArrayList.add("\u2022 " + remedy);
        }

        //Initialize ArrayAdapter to pass to ListView
                                                        /*Context,    list view layout,             array or arrayList*/
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.custom_list_view, remedyArrayList);

        // Create ListView object and link to reference in activity_main.xml
        // Only need to link the ListView in onCreate
        ListView remedyListView = (ListView) remedyDialog.findViewById(R.id.remedyListView);
        remedyListView.setAdapter(adapter); // Assign the ArrayAdapter to the ListView object

        Button doneButton;
        doneButton = (Button) remedyDialog.findViewById(R.id.remedyDoneButton);
        assert doneButton != null;
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Done Button from OTC Remedy Dialog was Clicked!");

                remedyDialog.dismiss();
                createAntibioticFactDialog();
            }
        });
        return remedyDialog;
    }

    /*
            This method creates a dialog for when the fever "yes" checkbox is selected.
            Only one fever range can be selected either low or high
     */
    private Dialog createFeverDialog() {
        final Dialog feverDialog = new Dialog(this);
        feverDialog.setContentView(R.layout.dialog_fever_layout);
        feverDialog.show();

        lowFeverRange = (CheckBox) feverDialog.findViewById(R.id.lowFeverRangeCheckBox);
        assert lowFeverRange != null;
        lowFeverRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Low Fever Range was selected.");


                addCheckBox(lowFeverRange, highFeverRange, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

        highFeverRange = (CheckBox) feverDialog.findViewById(R.id.highFeverRangeCheckBox);
        assert highFeverRange != null;
        highFeverRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "High Fever Range was selected.");
                addCheckBox(highFeverRange, lowFeverRange, selectedCheckBoxList, notSelectedCheckBoxList);

            }
        });

        Button cancelButton, confirmButton;

        cancelButton = (Button) feverDialog.findViewById(R.id.cancelButton);
        assert cancelButton != null;
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                        Check the selectedCheckBoxList list for "feverYes" and either of the available choices.
                        Check to make sure "feverYes" is not the only item selected.
                        Remove the added CheckBoxes from both the "selected" and
                            "notSelected" lists if "feverYes" and/or a fever range are selected.
                */

                if (selectedCheckBoxList.contains(feverYes) && (selectedCheckBoxList.contains(lowFeverRange) || selectedCheckBoxList.contains(highFeverRange))) {

                    for (int i = 1, n = selectedCheckBoxList.size(), m = notSelectedCheckBoxList.size(); i < 3; i++) {
                        selectedCheckBoxList.remove(n - i);
                        notSelectedCheckBoxList.remove(m - i);
                    }

                } else if (selectedCheckBoxList.contains(feverYes)) {

                    int n = selectedCheckBoxList.size();
                    selectedCheckBoxList.remove(n - 1);
                    n = notSelectedCheckBoxList.size();
                    notSelectedCheckBoxList.remove(n - 1);

                }


                // Debug Stuff --> --> --> -->
                Log.v(TAG, "Cancel Button from Fever Dialog was Clicked!");
                Log.v(TAG, "This is the selected checkbox list:");
                printSelectionList(selectedCheckBoxList);
                Log.v(TAG, "This is the not selected checkbox list:");
                printSelectionList(notSelectedCheckBoxList);


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
        return feverDialog;
    } // Closes the fever dialog method

    /*
            This method creates a dialog to prompt the user to choose what color their
            nasal discharge is.
    */
    private Dialog createNasalDischargeColorDialog() {
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
                addCheckBox(colorClear, colorYellowGreen, selectedCheckBoxList, notSelectedCheckBoxList);


            }
        });

        colorYellowGreen = (CheckBox) nasalDischargeDialog.findViewById(R.id.nasalDischargeColorYellowGreenCheckbox);
        assert colorYellowGreen != null;
        colorYellowGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Nasal Discharge Yellow Green was selected!!!");
                addCheckBox(colorYellowGreen, colorClear, selectedCheckBoxList, notSelectedCheckBoxList);
            }
        });

        Button cancelButton, confirmButton;

        cancelButton = (Button) nasalDischargeDialog.findViewById(R.id.cancelButton);
        assert cancelButton != null;
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Cancel Button from the Nasal Discharge Dialog was Clicked!");


                if (selectedCheckBoxList.contains(nasalDischargeYes) && (selectedCheckBoxList.contains(colorClear) || selectedCheckBoxList.contains(colorYellowGreen))) {

                    // Remove "nasalDischargeYes" and nasal discharge choice, two items total
                    // Remove "nasalDischargeNo" and nasal discharge choice not selected, two items total
                    // "m" variable is for when the list are different sizes
                    for (int i = 1, n = selectedCheckBoxList.size(), m = notSelectedCheckBoxList.size(); i < 3; i++) {
                        selectedCheckBoxList.remove(n - i);

                        notSelectedCheckBoxList.remove(m - i);
                    }

                } else if (selectedCheckBoxList.contains(nasalCongestionYes)) {

                    // Remove "nasalDischargeYes", one item total
                    // Remove "nasalDischargeNo", one item total
                    int n = selectedCheckBoxList.size();
                    selectedCheckBoxList.remove(n - 1);
                    // Reset "n" to account for the possibility the lists are different sizes
                    n = notSelectedCheckBoxList.size();
                    notSelectedCheckBoxList.remove(n - 1);
                }

                // Debug Stuff --> --> --> -->
                Log.v(TAG, "Cancel Button from Nasal Discharge Dialog was Clicked!");
                Log.v(TAG, "This is the selected checkbox list:");
                printSelectionList(selectedCheckBoxList);
                Log.v(TAG, "This is the not selected checkbox list:");
                printSelectionList(notSelectedCheckBoxList);

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

        return nasalDischargeDialog;
    } // Closes nasal discharge dialog method

    /*
            This method creates a dialog to prompt the user to select
            which pre-existing condition applies to them.
     */
    private Dialog createPreExistingConditionDialog() {

        final Dialog preExistingConditionDialog = new Dialog(this);
        preExistingConditionDialog.setContentView(R.layout.dialog_pre_existing_conditions_layout);
        preExistingConditionDialog.show();


        ////////////// CheckBox Instantiation Pre Existing Conditions Dialog //////////////////

        // Add Listeners for all the check boxes in Pre Existing Dialog

        pregnantOrTwoWeeksPostpartum = (CheckBox) preExistingConditionDialog.findViewById(R.id.pregnantPostpartumCheckbox);
        assert pregnantOrTwoWeeksPostpartum != null;
        pregnantOrTwoWeeksPostpartum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Pregnant Postpartum was selected!!!");
                pregnantOrTwoWeeksPostpartum.setEnabled(false);

            }
        });


        cancer = (CheckBox) preExistingConditionDialog.findViewById(R.id.cancerCheckbox);
        assert cancer != null;
        cancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cancer.setEnabled(false);
                Log.v(TAG, "Cancer was selected!!!");

            }
        });

        copd = (CheckBox) preExistingConditionDialog.findViewById(R.id.copdCheckbox);
        assert copd != null;
        copd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "COPD was selected!!!");
                copd.setEnabled(false);

            }
        });

        hiv = (CheckBox) preExistingConditionDialog.findViewById(R.id.hivCheckbox);
        assert hiv != null;
        hiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hiv.setEnabled(false);
                Log.v(TAG, "HIV was selected!!!");


            }
        });

        aids = (CheckBox) preExistingConditionDialog.findViewById(R.id.aidsCheckbox);
        assert aids != null;
        aids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "AIDS was selected!!!");
                aids.setEnabled(false);

            }
        });

        recentUseOfAntibiotic = (CheckBox) preExistingConditionDialog.findViewById(R.id.recentUseOfAntibioticCheckbox);
        assert recentUseOfAntibiotic != null;
        recentUseOfAntibiotic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Recent Use of Antibiotic was selected!!!");
                recentUseOfAntibiotic.setEnabled(false);

            }
        });

        recentHospitalization = (CheckBox) preExistingConditionDialog.findViewById(R.id.recentHospitalizationCheckbox);
        assert recentHospitalization != null;
        recentHospitalization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recentHospitalization.setEnabled(false);
                Log.v(TAG, "Recent Hospitalization was selected!!!");

            }
        });

        chronicSteroidUse = (CheckBox) preExistingConditionDialog.findViewById(R.id.chronicSteroidUseCheckbox);
        assert chronicSteroidUse != null;
        chronicSteroidUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.v(TAG, "Chronic Steroid Use was selected!!!");
                chronicSteroidUse.setEnabled(false);

            }
        });

        Button cancelButton, confirmButton;

        cancelButton = (Button) preExistingConditionDialog.findViewById(R.id.cancelButton);
        assert cancelButton != null;
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Debug Stuff --> --> --> -->
                Log.v(TAG, "Cancel Button from Pre Existing Conditions Dialog was Clicked!");
                Log.v(TAG, "This is the selected checkbox list:");
                printSelectionList(selectedCheckBoxList);
                Log.v(TAG, "This is the not selected checkbox list:");
                printSelectionList(notSelectedCheckBoxList);

                if (selectedCheckBoxList.contains(preExistingConditionsYes)) {
                    int n = selectedCheckBoxList.size();
                    selectedCheckBoxList.remove(n - 1);
                    n = notSelectedCheckBoxList.size();
                    notSelectedCheckBoxList.remove(n - 1);
                }

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

        return preExistingConditionDialog;
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
        yes.setClickable(true);
        no.setClickable(true);
    }

    /*
            This method disables the first checkbox parameter, sets the second checkbox parameter unclickable and adds both checkbox
            parameters to their corresponding lists.
     */
    private void addCheckBox(CheckBox chosen, CheckBox notChosen, ArrayList<CheckBox> selectedList, ArrayList<CheckBox> notSelectedList) {
        chosen.setEnabled(false);
        notChosen.setClickable(false);
        selectedList.add(chosen);
        notSelectedList.add(notChosen);
    }


    // Debug Stuff --> --> --> --> --> --> --> --> --> --> --> --> --> --> --> --> --> --> -->

    /*
            This method prints an array list to the console
    */
    private void printSelectionList(ArrayList<CheckBox> inputList) {

        for (CheckBox cb : inputList) {
            Log.v(TAG, "ID Number --> " + Integer.toString(cb.getId()) + " \nText Value --> " + cb.getText().toString());

        }
    }

} // Closes the QuestionnaireOneActivity Class
