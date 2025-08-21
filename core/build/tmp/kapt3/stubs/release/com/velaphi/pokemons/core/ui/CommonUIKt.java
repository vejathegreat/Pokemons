package com.velaphi.pokemons.core.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a(\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0012\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u00a8\u0006\n"}, d2 = {"EmptyState", "", "message", "", "modifier", "Landroidx/compose/ui/Modifier;", "ErrorContent", "onRetry", "Lkotlin/Function0;", "LoadingContent", "core_release"})
public final class CommonUIKt {
    
    /**
     * Common loading content component that can be reused across the app.
     * @param modifier Optional modifier for the component
     */
    @androidx.compose.runtime.Composable()
    public static final void LoadingContent(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Common error content component with retry button that can be reused across the app.
     * @param message The error message to display
     * @param onRetry Callback function when retry button is clicked
     * @param modifier Optional modifier for the component
     */
    @androidx.compose.runtime.Composable()
    public static final void ErrorContent(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRetry, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    /**
     * Common empty state component that can be reused across the app.
     * @param message The message to display when there's no content
     * @param modifier Optional modifier for the component
     */
    @androidx.compose.runtime.Composable()
    public static final void EmptyState(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}