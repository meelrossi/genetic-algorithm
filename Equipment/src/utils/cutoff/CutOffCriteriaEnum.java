package utils.cutoff;

public enum CutOffCriteriaEnum {
	Structure,
	Content,
	Generation,
	Optimal;
	
	public CutOffCriteria getCriteriaClass() {
		switch(this) {
		case Structure:
			return new StructureCriteria();
		case Content:
			return new ContentCriteria();
		case Generation:
			return new GenerationCriteria();
		case Optimal:
			return new OptimalCriteria();
		default:
			return null;
		}
	}
}
