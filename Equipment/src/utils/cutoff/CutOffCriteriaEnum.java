package utils.cutoff;

public enum CutOffCriteriaEnum {
	Structure, Content, Generation, Optimal;

	public CutOffCriteria getCriteriaClass(double parameter) {
		switch (this) {
		case Structure:
			return new StructureCriteria(parameter);
		case Content:
			return new ContentCriteria(parameter);
		case Generation:
			return new GenerationCriteria(parameter);
		case Optimal:
			return new OptimalCriteria(parameter);
		default:
			return null;
		}
	}
}
