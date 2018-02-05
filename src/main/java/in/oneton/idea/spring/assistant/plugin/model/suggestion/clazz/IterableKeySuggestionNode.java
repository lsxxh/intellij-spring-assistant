package in.oneton.idea.spring.assistant.plugin.model.suggestion.clazz;

import com.intellij.openapi.module.Module;
import in.oneton.idea.spring.assistant.plugin.completion.FileType;
import in.oneton.idea.spring.assistant.plugin.model.suggestion.Suggestion;
import in.oneton.idea.spring.assistant.plugin.model.suggestion.SuggestionNode;
import in.oneton.idea.spring.assistant.plugin.model.suggestion.SuggestionNodeType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.SortedSet;

class IterableKeySuggestionNode implements SuggestionNode {

  private final SuggestionNode unwrapped;

  IterableKeySuggestionNode(SuggestionNode unwrapped) {
    this.unwrapped = unwrapped;
  }

  @Nullable
  @Override
  public List<SuggestionNode> findDeepestSuggestionNode(Module module,
      List<SuggestionNode> matchesRootTillParentNode, String[] pathSegments,
      int pathSegmentStartIndex) {
    return unwrapped.findDeepestSuggestionNode(module, matchesRootTillParentNode, pathSegments,
        pathSegmentStartIndex);
  }

  @Nullable
  @Override
  public SortedSet<Suggestion> findKeySuggestionsForQueryPrefix(Module module, FileType fileType,
      List<SuggestionNode> matchesRootTillMe, int numOfAncestors, String[] querySegmentPrefixes,
      int querySegmentPrefixStartIndex) {
    return unwrapped
        .findKeySuggestionsForQueryPrefix(module, fileType, matchesRootTillMe, numOfAncestors,
            querySegmentPrefixes, querySegmentPrefixStartIndex);
  }

  @Override
  public String getDocumentationForKey(Module module, String nodeNavigationPathDotDelimited) {
    return unwrapped.getDocumentationForKey(module, nodeNavigationPathDotDelimited);
  }

  @Nullable
  @Override
  public SortedSet<Suggestion> findValueSuggestionsForPrefix(Module module, FileType fileType,
      List<SuggestionNode> matchesRootTillMe, String prefix) {
    return unwrapped.findValueSuggestionsForPrefix(module, fileType, matchesRootTillMe, prefix);
  }

  @Override
  public String getDocumentationForValue(Module module, String nodeNavigationPathDotDelimited,
      String value) {
    return unwrapped.getDocumentationForValue(module, nodeNavigationPathDotDelimited, value);
  }

  @Override
  public boolean isLeaf(Module module) {
    return unwrapped.isLeaf(module);
  }

  @Override
  public boolean isMetadataNonProperty() {
    return false;
  }

  @Nullable
  @Override
  public String getOriginalName() {
    return unwrapped.getOriginalName();
  }

  @Nullable
  @Override
  public String getNameForDocumentation(Module module) {
    return getOriginalName();
  }

  @Override
  public boolean supportsDocumentation() {
    return unwrapped.supportsDocumentation();
  }

  @NotNull
  @Override
  public SuggestionNodeType getSuggestionNodeType(Module module) {
    return unwrapped.getSuggestionNodeType(module);
  }

}
