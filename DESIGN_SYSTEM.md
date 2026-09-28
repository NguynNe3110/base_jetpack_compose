# App UI design system

Feature code should consume the `App*` components under
`ui/component` and tokens exposed by `AppThemeTokens`. Material 3 stays an
implementation detail of this layer, so a visual change can be made once and
applied throughout the app.

## Structure

- `ui/theme`: light/dark color schemes, the complete typography scale, shapes,
  and spacing tokens.
- `ui/component/button`: filled, tonal, elevated, outlined and text buttons;
  icon/toggle buttons; FABs; segmented controls.
- `ui/component/input`: text fields, checkbox, radio, switch, sliders, date and
  time pickers.
- `ui/component/display`: cards, list items, dividers, chips and badges.
- `ui/component/navigation`: top/bottom app bars, navigation bar/rail/drawer,
  and tabs.
- `ui/component/feedback`: dialogs, bottom sheet, snackbar and progress.
- `ui/component/layout`: scaffold and surface.
- `ui/component/menu`: dropdown menu.
- `feature/ComponentCatalogScreen.kt`: executable examples and visual catalog.

## Usage

```kotlin
AppTheme {
    AppScaffold(
        topBar = { AppTopAppBar("Profile") },
    ) { padding ->
        AppButton(
            text = "Save",
            onClick = ::save,
            modifier = Modifier.padding(padding),
        )
    }
}
```

Use `AppThemeTokens.colors`, `.typography`, `.shapes`, and `.spacing`; avoid
hard-coded color, text size, corner radius and spacing values in feature code.
Every wrapper keeps `Modifier`, state, callbacks, enabled/error state and the
relevant Material colors/shapes exposed, so one-off screens remain customizable.

## Component sizing

Use the component `size` parameter and `AppThemeTokens.dimensions` instead of
forcing `Modifier.height` on controls. In particular, `AppTextField` provides:

- `AppTextFieldSize.Standard`: minimum 56dp.
- `AppTextFieldSize.Compact`: minimum 48dp with smaller internal padding and
  typography. This is the supported compact input.

Do not force an input below 48dp. A 40dp-or-smaller field cannot reliably fit
text, cursor, label and font scaling, and it also violates the minimum touch
target. If a mockup shows a 40dp visual container, keep a 48dp interaction area
around it rather than shrinking the editable itself. Multi-line fields and
fields with supporting text are allowed to grow beyond their minimum height.

Not every experimental Material API should be wrapped pre-emptively. Add a new
`App*` wrapper when the product first uses that API, keeping its defaults tied
to the tokens above. This prevents a large unused compatibility surface while
preserving a single design-system boundary.
