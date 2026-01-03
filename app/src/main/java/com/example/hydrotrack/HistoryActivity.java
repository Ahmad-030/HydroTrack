tvHistory.setText(
    "Water: " + pref.getWater() + " ml\nTarget: " + pref.getTarget() + " ml"
        );

        btnClear.setOnClickListener(v -> {
        pref.clearAll();
});
